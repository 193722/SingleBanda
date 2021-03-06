package clud.qc.bicycle.core.generator.money;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum CurrencyEnum {
    CNY("CNY", "人民币", "￥", "156"),
    USD("USD", "美元", "$", "840"),
    JPY("JPY", "日元", "￥", "392"),
    HKD("HKD", "港币", "HK$", "344"),
    GBP("GBP", "英镑", "￡", "826"),
    EUR("EUR", "欧元", "EUR", "978"),
    AUD("AUD", "澳元", "", "036"),
    CAD("CAD", "加元", "", "124"),
    SGD("SGD", "坡币", "", "702"),
    NZD("NZD", "新西", "", "554"),
    TWD("TWD", "台币", "", "901"),
    KRW("KRW", "韩元", "", "410"),
    DKK("DKK", "丹朗", "", "208"),
    TRY("TRY", "土拉", "", "949"),
    MYR("MYR", "马来", "", "458"),
    THB("THB", "泰铢", "", "764"),
    INR("INR", "印卢", "", "356"),
    PHP("PHP", "菲比", "", "608"),
    CHF("CHF", "瑞士", "", "756"),
    SEK("SEK", "瑞典", "", "752"),
    ILS("ILS", "以谢", "", "376"),
    ZAR("ZAR", "南非", "", "710"),
    RUB("RUB", "俄卢", "", "643"),
    NOK("NOK", "挪威克朗", "", "578"),
    AED("AED", "阿联酋", "", "784"),
    BRL("BRL", "巴西雷亚尔", "", "986"),
    IDR("IDR", "印尼卢比", "", "360"),
    SAR("SAR", "沙特里亚尔", "", "682"),
    MXN("MXN", "墨西哥比索", "", "484"),
    PLN("PLN", "波兰兹罗提", "", "985"),
    VND("VND", "越南盾", "", "704"),
    CLP("CLP", "智利比索", "", "152"),
    KZT("KZT", "哈萨克腾格", "", "398"),
    CZK("CZK", "捷克克朗", "", "203"),
    NGN("NGN", "尼日利亚奈拉", "", "566"),
    COP("COP", "哥伦比亚比索", "", "170"),
    EGP("EGP", "埃及镑", "", "818"),
    VEF("VEF", "委玻利瓦尔", "", "937"),
    KWD("KWD", "科威特第纳尔", "", "414"),
    ARS("ARS", "阿根廷比索", "", "032"),
    MOP("MOP", "澳门元", "", "446"),
    RON("RON", "罗马尼亚列伊", "", "946"),
    QAR("QAR", "卡塔尔里亚尔", "", "634"),
    UAH("UAH", "乌格里夫纳", "", "980"),
    HUF("HUF", "匈牙利福林", "", "348"),
    PKR("PKR", "巴基斯坦卢比", "", "586"),
    LBP("LBP", "黎巴嫩镑", "", "422"),
    JOD("JOD", "约旦第纳尔", "", "400"),
    PEN("PEN", "秘鲁新索尔", "", "604");

    private final String code;
    private final String message;
    private final String symbol;
    private final String identify;

    private CurrencyEnum(String code, String message, String symbol, String identify) {
        this.code = code;
        this.message = message;
        this.symbol = symbol;
        this.identify = identify;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getIdentify() {
        return this.identify;
    }

    public static CurrencyEnum getByCode(String code) {
        CurrencyEnum[] arr$ = values();
        int len$ = arr$.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            CurrencyEnum _enum = arr$[i$];
            if (StringUtils.equals(_enum.getCode(), code)) {
                return _enum;
            }
        }

        return null;
    }

    public static CurrencyEnum getByIdentify(String identify) {
        CurrencyEnum[] arr$ = values();
        int len$ = arr$.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            CurrencyEnum _enum = arr$[i$];
            if (StringUtils.equals(_enum.getIdentify(), identify)) {
                return _enum;
            }
        }

        return null;
    }

    public List<CurrencyEnum> getAllEnum() {
        ArrayList list = new ArrayList();
        CurrencyEnum[] arr$ = values();
        int len$ = arr$.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            CurrencyEnum _enum = arr$[i$];
            list.add(_enum);
        }

        return list;
    }

    public List<String> getAllEnumCode() {
        ArrayList list = new ArrayList();
        CurrencyEnum[] arr$ = values();
        int len$ = arr$.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            CurrencyEnum _enum = arr$[i$];
            list.add(_enum.code());
        }

        return list;
    }

    public boolean isInList(CurrencyEnum... values) {
        CurrencyEnum[] arr$ = values;
        int len$ = values.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            CurrencyEnum e = arr$[i$];
            if (this == e) {
                return true;
            }
        }

        return false;
    }
}
