//package com.stan.springbootcourse.util.utilities;
//
//import com.systemspecs.remita.vending.vendingcommon.dto.response.TransactionResponse;
//import com.systemspecs.remita.vending.vendingcommon.enums.OutcomeType;
//import com.systemspecs.remita.vending.vendingcommon.enums.TransactionStatus;
//
///**
// * Maps provider transaction outcomes to OutcomeType used for rating + cooldown logic.
// * Initial heuristic implementation; refine classification rules later.
// */
//public final class OutcomeMappingUtil {
//
//    private OutcomeMappingUtil() {}
//
//    /**
//     * Derive OutcomeType from TransactionResponse & latency context.
//     * @param response provider response (may be null if timeout)
//     * @param timedOut whether the call exceeded timeout
//     * @return mapped OutcomeType
//     */
//    public static OutcomeType map(TransactionResponse response, boolean timedOut) {
//        if (timedOut || response == null) {
//            return OutcomeType.TIMEOUT; // includes network/unreachable scenarios
//        }
//        TransactionStatus status = response.getStatus();
//        if (status == null) {
//            return OutcomeType.TECHNICAL_FAILURE;
//        }
//        switch (status) {
//            case SUCCESS:
//            case COMPLETED:
//            case CONFIRMED:
//                return OutcomeType.SUCCESS;
//            case SYSTEM_ERROR:
//                return OutcomeType.TECHNICAL_FAILURE;
//            case TRANSACTION_FAILED:
//                // Distinguish business rejection vs provider error: use processorResponseCode semantics if available
//                String code = response.getProcessorResponseCode();
//                if (code != null && isCustomerIssue(code)) {
//                    return OutcomeType.BUSINESS_REJECTION;
//                }
//                return OutcomeType.PROVIDER_ERROR;
//            case PENDING:
//                // PENDING after initial attempt treated as technical failure (could be retry/poll situation)
//                return OutcomeType.TECHNICAL_FAILURE;
//            default:
//                return OutcomeType.PROVIDER_ERROR;
//        }
//    }
//
//    private static boolean isCustomerIssue(String code) {
//        // Simple heuristic list – extend with real business rejection codes later.
//        return code.equalsIgnoreCase("INVALID_ACCOUNT") ||
//            code.equalsIgnoreCase("INCORRECT_AMOUNT") ||
//            code.equalsIgnoreCase("INSUFFICIENT_FUND") ||
//            code.equalsIgnoreCase("INVALID_PARAMETER") ||
//            code.equalsIgnoreCase("NOT_FOUND") ||
//            code.equalsIgnoreCase("CUSTOMER_DEBT");
//    }
//}
//
