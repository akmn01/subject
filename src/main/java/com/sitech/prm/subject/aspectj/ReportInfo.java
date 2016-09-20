package com.sitech.prm.subject.aspectj;




public class ReportInfo {
	/**
	 * <p>
	 * Discription:[字段功能描述]
	 * </p>
	 */
	private static final long serialVersionUID = -8370483230049229226L;

	/**
	 * 报表编码
	 */
	private String reportCode;

	/**
	 * 报表名称
	 */
	private String reportName;

	/**
	 * 报表类型
	 */
	private String reportType;

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public ReportInfo(String reportCode) {
		super();
		this.reportCode = reportCode;
	}
	
	

	

}
