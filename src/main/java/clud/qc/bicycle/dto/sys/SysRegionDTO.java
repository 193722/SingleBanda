package clud.qc.bicycle.dto.sys;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class SysRegionDTO extends Object implements Serializable {

    private String ID;
    private String ParentId;
    private String Name;
    private String MergerName;
    private String ShortName;
    private String MergerShortName;
    private String LevelType;
    private String CityCode;
    private String ZipCode;
    private String Pinyin;
    private String Jianpin;
    private String FirstChar;
    private String lng;
    private String Lat;
    private String Remarks;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String parentId) {
        ParentId = parentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMergerName() {
        return MergerName;
    }

    public void setMergerName(String mergerName) {
        MergerName = mergerName;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public String getMergerShortName() {
        return MergerShortName;
    }

    public void setMergerShortName(String mergerShortName) {
        MergerShortName = mergerShortName;
    }

    public String getLevelType() {
        return LevelType;
    }

    public void setLevelType(String levelType) {
        LevelType = levelType;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getPinyin() {
        return Pinyin;
    }

    public void setPinyin(String pinyin) {
        Pinyin = pinyin;
    }

    public String getJianpin() {
        return Jianpin;
    }

    public void setJianpin(String jianpin) {
        Jianpin = jianpin;
    }

    public String getFirstChar() {
        return FirstChar;
    }

    public void setFirstChar(String firstChar) {
        FirstChar = firstChar;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
