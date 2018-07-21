package clud.qc.bicycle.entity.sys;

import clud.qc.bicycle.core.ground.entity.BaseDO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_region")
public class SysRegionDO extends BaseDO {
	/**
	 * 区域编码
	 */
	@Id
	@Column(name = "region_id")
	private String regionId;
	
	/**
	 * 父地域编码
	 */
	@Column(name = "parent_id")
	private String parentId;
	
	/**
	 * 地域名称
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 地域组合名称
	 */
	@Column(name = "merger_name")
	private String mergerName;
	
	/**
	 * 简称
	 */
	@Column(name = "short_name")
	private String shortName;
	
	/**
	 * 地域组合简称
	 */
	@Column(name = "merger_short_name")
	private String mergerShortName;
	
	/**
	 * 地域等级
	 */
	@Column(name = "level_type")
	private String levelType;
	
	/**
	 * 城市编码
	 */
	@Column(name = "city_code")
	private String cityCode;
	
	/**
	 * 邮编
	 */
	@Column(name = "zip_code")
	private String zipCode;
	
	/**
	 * 拼音
	 */
	@Column(name = "pinyin")
	private String pinyin;
	
	/**
	 * 简拼
	 */
	@Column(name = "jianpin")
	private String jianpin;
	
	/**
	 * 首字母
	 */
	@Column(name = "first_char")
	private String firstChar;
	
	/**
	 * 经度
	 */
	@Column(name = "lng")
	private String lng;
	
	/**
	 * 纬度
	 */
	@Column(name = "lat")
	private String lat;
	
	/**
	 * 备注
	 */
	@Column(name = "remarks")
	private String remarks;
	
	/**
	 * 获取区域编码
	 *
	 * @return region_id - 区域编码
	 */
	public String getRegionId() {
		return regionId;
	}
	
	/**
	 * 设置区域编码
	 *
	 * @param regionId 区域编码
	 */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	
	/**
	 * 获取父地域编码
	 *
	 * @return parent_id - 父地域编码
	 */
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置父地域编码
	 *
	 * @param parentId 父地域编码
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * 获取地域名称
	 *
	 * @return name - 地域名称
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置地域名称
	 *
	 * @param name 地域名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取地域组合名称
	 *
	 * @return merger_name - 地域组合名称
	 */
	public String getMergerName() {
		return mergerName;
	}
	
	/**
	 * 设置地域组合名称
	 *
	 * @param mergerName 地域组合名称
	 */
	public void setMergerName(String mergerName) {
		this.mergerName = mergerName;
	}
	
	/**
	 * 获取简称
	 *
	 * @return short_name - 简称
	 */
	public String getShortName() {
		return shortName;
	}
	
	/**
	 * 设置简称
	 *
	 * @param shortName 简称
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	/**
	 * 获取地域组合简称
	 *
	 * @return merger_short_name - 地域组合简称
	 */
	public String getMergerShortName() {
		return mergerShortName;
	}
	
	/**
	 * 设置地域组合简称
	 *
	 * @param mergerShortName 地域组合简称
	 */
	public void setMergerShortName(String mergerShortName) {
		this.mergerShortName = mergerShortName;
	}
	
	/**
	 * 获取地域等级
	 *
	 * @return level_type - 地域等级
	 */
	public String getLevelType() {
		return levelType;
	}
	
	/**
	 * 设置地域等级
	 *
	 * @param levelType 地域等级
	 */
	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}
	
	/**
	 * 获取城市编码
	 *
	 * @return city_code - 城市编码
	 */
	public String getCityCode() {
		return cityCode;
	}
	
	/**
	 * 设置城市编码
	 *
	 * @param cityCode 城市编码
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	/**
	 * 获取邮编
	 *
	 * @return zip_code - 邮编
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * 设置邮编
	 *
	 * @param zipCode 邮编
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * 获取拼音
	 *
	 * @return pinyin - 拼音
	 */
	public String getPinyin() {
		return pinyin;
	}
	
	/**
	 * 设置拼音
	 *
	 * @param pinyin 拼音
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
	/**
	 * 获取简拼
	 *
	 * @return jianpin - 简拼
	 */
	public String getJianpin() {
		return jianpin;
	}
	
	/**
	 * 设置简拼
	 *
	 * @param jianpin 简拼
	 */
	public void setJianpin(String jianpin) {
		this.jianpin = jianpin;
	}
	
	/**
	 * 获取首字母
	 *
	 * @return first_char - 首字母
	 */
	public String getFirstChar() {
		return firstChar;
	}
	
	/**
	 * 设置首字母
	 *
	 * @param firstChar 首字母
	 */
	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}
	
	/**
	 * 获取经度
	 *
	 * @return lng - 经度
	 */
	public String getLng() {
		return lng;
	}
	
	/**
	 * 设置经度
	 *
	 * @param lng 经度
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	/**
	 * 获取纬度
	 *
	 * @return lat - 纬度
	 */
	public String getLat() {
		return lat;
	}
	
	/**
	 * 设置纬度
	 *
	 * @param lat 纬度
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	/**
	 * 获取备注
	 *
	 * @return remarks - 备注
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * 设置备注
	 *
	 * @param remarks 备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}