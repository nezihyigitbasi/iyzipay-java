package com.iyzipay.model;

import com.google.gson.annotations.SerializedName;
import com.iyzipay.DigestHelper;
import com.iyzipay.HttpClient;
import com.iyzipay.IyzipayResource;
import com.iyzipay.Options;
import com.iyzipay.request.CreateThreeDSInitializeRequest;

public class ThreeDSInitializePreAuth extends IyzipayResource {

    @SerializedName("threeDSHtmlContent")
    private String htmlContent;

    public static ThreeDSInitializePreAuth create(CreateThreeDSInitializeRequest request, Options options) {
        ThreeDSInitializePreAuth response = HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/initialize3ds/preauth/ecom",
                getHttpHeaders(request, options),
                request,
                ThreeDSInitializePreAuth.class);
        if (response != null) {
            response.setHtmlContent(DigestHelper.decodeString(response.getHtmlContent()));
        }
        return response;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}