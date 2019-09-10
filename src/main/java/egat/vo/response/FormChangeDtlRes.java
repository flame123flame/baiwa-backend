package egat.vo.response;

import java.util.List;

public class FormChangeDtlRes {
	private String textLabel;
	private String inputType;
	private String hintText;
	private String groupSelect;
	private boolean fieldEnabled = true;
	private boolean require = false;
	private Long order;
	private String valueStr;
	private Double alignmentText;
	private String colorText;
	private Double fontSize;

	private List<FormChangeDtl2Res> valueObj;

	public String getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(String textLabel) {
		this.textLabel = textLabel;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getHintText() {
		return hintText;
	}

	public void setHintText(String hintText) {
		this.hintText = hintText;
	}

	public String getGroupSelect() {
		return groupSelect;
	}

	public void setGroupSelect(String groupSelect) {
		this.groupSelect = groupSelect;
	}

	public boolean isFieldEnabled() {
		return fieldEnabled;
	}

	public void setFieldEnabled(boolean fieldEnabled) {
		this.fieldEnabled = fieldEnabled;
	}

	public boolean isRequire() {
		return require;
	}

	public void setRequire(boolean require) {
		this.require = require;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public String getValueStr() {
		return valueStr;
	}

	public void setValueStr(String valueStr) {
		this.valueStr = valueStr;
	}

	public List<FormChangeDtl2Res> getValueObj() {
		return valueObj;
	}

	public void setValueObj(List<FormChangeDtl2Res> valueObj) {
		this.valueObj = valueObj;
	}

	public Double getAlignmentText() {
		return alignmentText;
	}

	public void setAlignmentText(Double alignmentText) {
		this.alignmentText = alignmentText;
	}

	public String getColorText() {
		return colorText;
	}

	public void setColorText(String colorText) {
		this.colorText = colorText;
	}

	public Double getFontSize() {
		return fontSize;
	}

	public void setFontSize(Double fontSize) {
		this.fontSize = fontSize;
	}

}
