package org.daisy.dotify.formatter.impl.page;

import java.util.List;
import java.util.Stack;

import org.daisy.dotify.api.formatter.FormattingTypes.BreakBefore;
import org.daisy.dotify.formatter.impl.core.Block;
import org.daisy.dotify.formatter.impl.core.BlockContext;
import org.daisy.dotify.formatter.impl.core.LayoutMaster;
import org.daisy.dotify.formatter.impl.row.BlockStatistics;
import org.daisy.dotify.formatter.impl.row.LineProperties;

/**
 * Provides data about a single rendering scenario.
 * 
 * @author Joel Håkansson
 */
class ScenarioData extends BlockProcessor {
	private Stack<RowGroupSequence> dataGroups = new Stack<>();

	ScenarioData() {
		super();
		dataGroups = new Stack<>();
	}

	/**
	 * Creates a deep copy of the supplied instance
	 * @param template the instance to copy
	 */
	ScenarioData(ScenarioData template) {
		super(template);
		dataGroups = new Stack<>();
		for (RowGroupSequence rgs : template.dataGroups) {
			dataGroups.add(new RowGroupSequence(rgs));
		}
	}

	float calcSize() {
		float size = 0;
		for (RowGroupSequence rgs : dataGroups) {
			for (RowGroup rg : rgs.getGroup()) {
				size += rg.getUnitSize();
			}
		}
		return size;
	}
	
	private boolean isDataEmpty() {
		return (dataGroups.isEmpty()||dataGroups.peek().getGroup().isEmpty());
	}
	
	private boolean hasSequence() {
		return !dataGroups.isEmpty();
	}
	
	private boolean hasResult() {
		return !isDataEmpty();
	}
	
	protected void newRowGroupSequence(BreakBefore breakBefore, VerticalSpacing vs) {
		RowGroupSequence rgs = new RowGroupSequence(breakBefore, vs);
		dataGroups.add(rgs);
	}
	
	@Override
	protected void setVerticalSpacing(VerticalSpacing vs) {
		dataGroups.push(new RowGroupSequence(dataGroups.pop(), vs));
	}

	RowGroup peekResult() {
		return dataGroups.peek().currentGroup();
	}

	List<RowGroupSequence> getDataGroups() {
		return dataGroups;
	}
	
	void processBlock(LayoutMaster master, Block g, BlockContext bc) {
		loadBlock(master, g, bc, hasSequence(), hasResult());
		while (hasNextInBlock()) {
			getNextRowGroup(bc, LineProperties.DEFAULT)
			.ifPresent(rg->dataGroups.peek().getGroup().add(rg));
		}
		dataGroups.peek().getBlocks().add(g);
	}
	

	/**
	 * Gets the current block's statistics, or null if no block has been loaded.
	 * @return returns the block statistics, or null
	 */
	BlockStatistics getBlockStatistics() {
		if (rowGroupProvider!=null) {
			return rowGroupProvider.getBlockStatistics();
		} else {
			return null;
		}
	}
}