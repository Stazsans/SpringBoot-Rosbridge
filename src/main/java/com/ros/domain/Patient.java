package com.ros.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName patient
 */
@TableName(value ="patient")
@Data
public class Patient implements Serializable {
    /**
     * 病人id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 病人姓名
     */
    @TableField(value = "patient_name")
    private String patientName;

    /**
     * 病人电话
     */
    @TableField(value = "patient_phone")
    private String patientPhone;

    /**
     * 病人地址
     */
    @TableField(value = "patient_address")
    private String patientAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Patient other = (Patient) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPatientName() == null ? other.getPatientName() == null : this.getPatientName().equals(other.getPatientName()))
            && (this.getPatientPhone() == null ? other.getPatientPhone() == null : this.getPatientPhone().equals(other.getPatientPhone()))
            && (this.getPatientAddress() == null ? other.getPatientAddress() == null : this.getPatientAddress().equals(other.getPatientAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPatientName() == null) ? 0 : getPatientName().hashCode());
        result = prime * result + ((getPatientPhone() == null) ? 0 : getPatientPhone().hashCode());
        result = prime * result + ((getPatientAddress() == null) ? 0 : getPatientAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patientName=").append(patientName);
        sb.append(", patientPhone=").append(patientPhone);
        sb.append(", patientAddress=").append(patientAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}