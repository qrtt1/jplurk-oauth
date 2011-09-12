package com.google.jplurk_oauth;

/**
 * Handle Qualifier of Message
 */
public enum Qualifier {

	// ":" 無. 同 "QUALIFIER_FREESTYLE".
	NULL(":"),

	// "wants" 想要
	WANTS("wants"),

	// "needs" 需要
	NEEDS("needs"),

	// "says" 說
	SAYS("says"),

	// "asks" 問
	ASKS("asks"),

	// "wonders" 好奇
	WONDERS("wonders"),

	// "freestyle" 自由發揮
	FREESTYLE("freestyle"),

	// "is" 正在
	IS("is"),

	// "shares" 推
	SHARES("shares"),

	// "will" 打算
	WILL("will"),

	// "feels" 覺得
	FEELS("feels"),

	// "wishes" 希望
	WISHES("wishes"),

	// "likes" 喜歡
	LIKES("likes"),

	// "loves" 愛
	LOVES("loves"),

	// "hopes" 希望
	HOPES("hopes"),

	// "has" 已經
	HAS("has"),

	// "was" 曾經
	WAS("was"),

	// "thinks" 想
	THINKS("thinks"),

	// "hates" 討厭
	HATES("hates"),

	// "gives" 給
	GIVES("gives")
	;

	private String qualifier;

	Qualifier(String qualifier){
		this.qualifier = qualifier;
	}

    /**
     * Input Qualifier String, then it will select correct Qualifier.
     * @param qualifier Qualifier String
     * @return
     */
    public static Qualifier fromString(String qualifier){
		for (Qualifier q : Qualifier.values()) {
			if(q.toString().equals(qualifier)){
				return q;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return qualifier;
	}

}
