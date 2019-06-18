package com.ch.lesson.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2019-04-15
 */
@TableName("dictionary_detail")
public class DictionaryDetail extends Model<DictionaryDetail> {

    private static final long serialVersionUID = 1L;

	@TableId(value="Id", type= IdType.AUTO)
	private Integer Id;
	@TableField("DictionaryId")
	private Integer DictionaryId;
    /**
     * 一类dictionary下唯一
     */
	@TableField("ItemKey")
	private Integer ItemKey;
	@TableField("ItemValue")
	private String ItemValue;
	@TableField("IsDefault")
	private Boolean IsDefault;
    /**
     * 排序
     */
	@TableField("Position")
	private Integer Position;
	@TableField("CreateDate")
	private String CreateDate;
	@TableField("CreateBy")
	private Integer CreateBy;
	@TableField("ModifyDate")
	private String ModifyDate;
	@TableField("ModifyBy")
	private Integer ModifyBy;


	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public Integer getDictionaryId() {
		return DictionaryId;
	}

	public void setDictionaryId(Integer DictionaryId) {
		this.DictionaryId = DictionaryId;
	}

	public Integer getItemKey() {
		return ItemKey;
	}

	public void setItemKey(Integer ItemKey) {
		this.ItemKey = ItemKey;
	}

	public String getItemValue() {
		return ItemValue;
	}

	public void setItemValue(String ItemValue) {
		this.ItemValue = ItemValue;
	}

	public Boolean isIsDefault() {
		return IsDefault;
	}

	public void setIsDefault(Boolean IsDefault) {
		this.IsDefault = IsDefault;
	}

	public Integer getPosition() {
		return Position;
	}

	public void setPosition(Integer Position) {
		this.Position = Position;
	}

	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String CreateDate) {
		this.CreateDate = CreateDate;
	}

	public Integer getCreateBy() {
		return CreateBy;
	}

	public void setCreateBy(Integer CreateBy) {
		this.CreateBy = CreateBy;
	}

	public String getModifyDate() {
		return ModifyDate;
	}

	public void setModifyDate(String ModifyDate) {
		this.ModifyDate = ModifyDate;
	}

	public Integer getModifyBy() {
		return ModifyBy;
	}

	public void setModifyBy(Integer ModifyBy) {
		this.ModifyBy = ModifyBy;
	}

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

}
