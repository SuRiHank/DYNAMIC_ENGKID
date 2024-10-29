package com.webtoeic.controller;

import com.webtoeic.config.Config;
import com.webtoeic.dto.PaymentResDTO;
import com.webtoeic.dto.TransactionStatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
//    @GetMapping("/create_payment")
//    public ResponseEntity<?> createPayment(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
//
//        String orderType = "other";
////        long amount = Integer.parseInt(req.getParameter("amount")) * 100;
////        String bankCode = req.getParameter("bankCode");
//        long amount = 1000;
//
//        String vnp_TxnRef = Config.getRandomNumber(8);
//        String vnp_IpAddr = Config.getIpAddress(req);
//
//        String vnp_TmnCode = Config.vnp_TmnCode;
//
//        Map<String, String> vnp_Params = new HashMap<>();
//        vnp_Params.put("vnp_Version", Config.vnp_Version);
//        vnp_Params.put("vnp_Command", Config.vnp_Command);
//        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
//        vnp_Params.put("vnp_Amount", String.valueOf(amount));
//        vnp_Params.put("vnp_CurrCode", "USD");
//        vnp_Params.put("vnp_BankCode", "NCB");
//        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
//        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
//        vnp_Params.put("vnp_Locale", "vn");
//        vnp_Params.put("vnp_ReturnUrl",Config.vnp_ReturnUrl);
//        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
//        vnp_Params.put("vnp_OrderType", orderType);
//
////        String locate = req.getParameter("language");
////        if (locate != null && !locate.isEmpty()) {
////            vnp_Params.put("vnp_Locale", locate);
////        } else {
////            vnp_Params.put("vnp_Locale", "vn");
////        }
////        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
//
//
//        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//        String vnp_CreateDate = formatter.format(cld.getTime());
//        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
//
//        cld.add(Calendar.MINUTE, 15);
//        String vnp_ExpireDate = formatter.format(cld.getTime());
//        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
//
//        List fieldNames = new ArrayList(vnp_Params.keySet());
//        Collections.sort(fieldNames);
//        StringBuilder hashData = new StringBuilder();
//        StringBuilder query = new StringBuilder();
//        Iterator itr = fieldNames.iterator();
//        while (itr.hasNext()) {
//            String fieldName = (String) itr.next();
//            String fieldValue = (String) vnp_Params.get(fieldName);
//            if ((fieldValue != null) && (fieldValue.length() > 0)) {
//                //Build hash data
//                hashData.append(fieldName);
//                hashData.append('=');
//                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
//                //Build query
//                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
//                query.append('=');
//                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
//                if (itr.hasNext()) {
//                    query.append('&');
//                    hashData.append('&');
//                }
//            }
//        }
//        String queryUrl = query.toString();
//        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
//        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
//        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
//        PaymentResDTO paymentResDTO = new PaymentResDTO();
//        paymentResDTO.setStatus("OK");
//        paymentResDTO.setMessage("Payment successful");
//        paymentResDTO.setURL(paymentUrl);
////        com.google.gson.JsonObject job = new JsonObject();
////        job.addProperty("code", "00");
////        job.addProperty("message", "success");
////        job.addProperty("data", paymentUrl);
////        Gson gson = new Gson();
////        resp.getWriter().write(gson.toJson(job));
//        return ResponseEntity.status(HttpStatus.OK).body(paymentResDTO);
//    }
@GetMapping("/create_payment")
public void createPayment(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    String orderType = "other";
    long amount = 39000 * 100; // 39,000 VND

    String vnp_TxnRef = Config.getRandomNumber(8);
    String vnp_IpAddr = Config.getIpAddress(req);
    String vnp_TmnCode = Config.vnp_TmnCode;

    Map<String, String> vnp_Params = new HashMap<>();
    vnp_Params.put("vnp_Version", Config.vnp_Version);
    vnp_Params.put("vnp_Command", Config.vnp_Command);
    vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
    vnp_Params.put("vnp_Amount", String.valueOf(amount));
    vnp_Params.put("vnp_CurrCode", "VND");
    vnp_Params.put("vnp_BankCode", "NCB");
    vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
    vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
    vnp_Params.put("vnp_Locale", "vn");
    vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
    vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
    vnp_Params.put("vnp_OrderType", orderType);

    Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    String vnp_CreateDate = formatter.format(cld.getTime());
    vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

    cld.add(Calendar.MINUTE, 15);
    String vnp_ExpireDate = formatter.format(cld.getTime());
    vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

    List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
    Collections.sort(fieldNames);
    StringBuilder hashData = new StringBuilder();
    StringBuilder query = new StringBuilder();

    for (String fieldName : fieldNames) {
        String fieldValue = vnp_Params.get(fieldName);
        if (fieldValue != null && fieldValue.length() > 0) {
            hashData.append(fieldName).append('=').append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
            query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString())).append('=').append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
            if (!fieldName.equals(fieldNames.get(fieldNames.size() - 1))) {
                query.append('&');
                hashData.append('&');
            }
        }
    }

    String queryUrl = query.toString();
    String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
    queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
    String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;

    resp.sendRedirect(paymentUrl);
}

    @GetMapping("/payment_info")
    public ResponseEntity<?> transaction(@RequestParam(value="vnp_Amount") String amount,
                                         @RequestParam(value="vnp_BankCode") String bankCode,
                                         @RequestParam(value="vnp_OrderInfo") String orderInfo,
                                         @RequestParam(value="vnp_ResponseCode") String responseCode){
        TransactionStatusDTO transactionStatusDTO = new TransactionStatusDTO();

        if (responseCode.equals("00")){
            transactionStatusDTO.setStatus("OK");
            transactionStatusDTO.setMessage("Payment successful");
            transactionStatusDTO.setData("");
        }else{
            transactionStatusDTO.setStatus("No");
            transactionStatusDTO.setMessage("Payment failed");
            transactionStatusDTO.setData("");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transactionStatusDTO);
    }

}
