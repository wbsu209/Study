/*
package Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum CoreSyncType {
    CORE_SYNC_REQUIRED("Y", AccountType.NORMAL),
    CORE_SYNC_NOT_REQUIRED("N", AccountType.NORMAL),
    CORE_SYNC_FORCED("S", AccountType.SUPER);

    private final String code;
    private final AccountType accountType;

    private static final Map<String, CoreSyncType> CODE_MAP = Arrays.stream(values())
        .collect(Collectors.toMap(CoreSyncType::getCode, Function::identity));

    CoreSyncType(String code, AccountType AccountType) {
        this.code = code;
        this.accountType = accountType;
    }

    public String getCode() {
        return code;
    }

    public String getRequiredAccountType() {
        return accountType;
    }

    public static CoreSyncType getByCode(String code) {
        return CODE_MAP.getOrDefault(code, CORE_SYNC_REQUIRED);
    }
}
*/