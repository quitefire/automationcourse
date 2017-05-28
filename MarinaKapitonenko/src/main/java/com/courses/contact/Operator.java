package com.courses.contact;

enum Operator {
	LIFE("063", "073", "093"),
	KIEVSTAR("067", "096", "097");

	private String[] mCodes;

	Operator(String... codes) {
		mCodes = codes;
	}

	public String[] getCodes() {
		return mCodes;
	}


}
