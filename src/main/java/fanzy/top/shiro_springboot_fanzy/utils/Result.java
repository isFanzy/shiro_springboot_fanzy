/**
 * @program: shiro_springboot_fanzy
 * @description:
 * @author: fanzy
 * @create: 2022-09-22 14:21
 **/
package fanzy.top.shiro_springboot_fanzy.utils;

import lombok.Data;

@Data
public class Result {

	private Object data;
	private Integer code;
	private String message;

	public Result(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(Object data, Integer code, String message) {
		this.data = data;
		this.code = code;
		this.message = message;
	}

	public static Result success(Object data) {
		return new Result(data, 200, "success");
	}

	public static Result success(Object data, Integer code, String message) {
		return new Result(data, code, message);
	}

	public static Result fail(Object data, Integer code, String message) {
		return new Result(data, code, message);
	}
}

