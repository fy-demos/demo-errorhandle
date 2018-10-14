package com.lomagicode.example.errorhandle.bookstore.errorcode;


import com.lomagicode.example.errorhandle.commons.error.ErrorCode;

/**
 * 模块专属错误码，可以在通用错误码中没有符合场景时，自定义错误码
 * <p>
 * Created on Oct 10, 2018
 *
 * @author Chuan Qin
 * @see com.lomagicode.example.errorhandle.commons.error.CommonErrorCode#NOT_FOUND
 */
public enum BookStoreErrorCode implements ErrorCode {
    /**
     * 虽然<strong>不推荐</strong>，但允许在模块中自定义新的错误码，而不去使用通用库中已经定义的 {@link com.lomagicode.example.errorhandle.commons.error.CommonErrorCode#NOT_FOUND} 错误码
     */
    NOT_FOUND_BOOK("NotFoundBook", "Book {0} not found."),

    /**
     * 有如下两种定义错误码的思路：
     * 1. 定义宽泛的错误码，传入参数，如 Exists，传入 Book[id=1]
     * 2. 定义特定的错误码，如 InvalidBookId.Exists，不用传入参数
     * <p>
     * 具体采用哪种，可以根据喜好来决定，个人更偏向于定义相对宽泛的错误码，上面的 {@link #NOT_FOUND_BOOK} 示例也类似
     */
    EXISTS("Exists", "The specified object {0} already exists."),
    INVALID_BOOK_ID_EXISTS("InvalidBookId.Exists", "The specified bookId already exists.");

    BookStoreErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Customized error code
     */
    private String code;
    /**
     * Error message details
     */
    private String message;

    @Override
    public String getCode() {
        return "BookStore." + code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
