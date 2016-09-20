package com.sitech.prm.subject.jmockit;

public class WinportUrlServiceImpl extends WinportBaseService implements
		WinportUrlService {
	
	public boolean hasWinport(String memberId) {
		System.out.println("xxx");
		return true;
	}

	public String getWinportUrlThrowException(String memberId) {
		throw new RuntimeException();
	}
}