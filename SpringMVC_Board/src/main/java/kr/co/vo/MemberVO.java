package kr.co.vo;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberVO {

	private String userId;
	private String userPass;
	private String userName;
	private Date regDate;
	
}
