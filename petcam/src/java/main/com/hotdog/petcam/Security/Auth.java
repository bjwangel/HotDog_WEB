package com.hotdog.petcam.Security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD, ElementType.TYPE} )    // 타겟 설정 ! Method 와 Class 까지
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	String role() default "user";   // 기본 권한을 일반 user로 설정 
//	boolean required() default false; // required 기본을 false로
}
