package com.example.demo.msisdn.service;

import com.example.demo.msisdn.domain.MobileNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class MobileService {
    private static final Logger log = LoggerFactory.getLogger(MobileService.class);

    private static final String MOBILE_NUMBER_CODE = "07";
    private static final String COUNTRY_CODE = "46";
    private static final String  ZERO_WITH_COUNTRY_CODE= "0046";
    private static final String  COUNTRY_CODE_WITH_MOBILE_NUMBER= "4607";
    private static final String  INVALID= "invalid";

    public MobileService() {}

    public MobileNumber getValidMobileNumbers(MobileNumber dto) {
        log.info("Before format: {}", dto);
        return getMSISDN(dto.getNumbers());
    }

    private MobileNumber getMSISDN(String numbers[]) {
        List<String> result = new LinkedList<>();
        String replaceExpr = "[\\-\\+\\s+]";
        List<String> list = Arrays.asList(numbers);
        for(String number : list) {
            number = number.trim().replaceAll(replaceExpr, "");
            number = getOnlyDigits(number) ? getValidMSISDN(number) : INVALID;
            result.add(number);
        }
        String resultArr[] = result.toArray(new String[result.size()]);
        log.info("After format: {}", result.toString());
        return new MobileNumber(resultArr);
    }

    private static boolean getOnlyDigits(String s) {
        Pattern pattern = Pattern.compile("[0-9]{10,13}");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private static String getValidMSISDN(String number) {
        String prefix = "+";
        if (number.startsWith(COUNTRY_CODE) && number.length() == 11) {
            number = prefix.concat(number);
        } else if (number.startsWith(ZERO_WITH_COUNTRY_CODE) && number.length() == 13) {
            number = number.replaceFirst("00", prefix);
        } else if (number.startsWith(MOBILE_NUMBER_CODE) && number.length() == 10) {
            number = number.replaceFirst("0", "+46");
        } else if (number.startsWith(COUNTRY_CODE_WITH_MOBILE_NUMBER) && number.length() == 12) {
            number = number.replaceFirst("4607", "+467");
        } else {
            number = INVALID;
        }
        return number;
    }
}
