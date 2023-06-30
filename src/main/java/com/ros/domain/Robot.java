package com.ros.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName robot
 */
@TableName(value ="robot")
@Data
public class Robot implements Serializable {
    /**
     * 小车id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 小车名字
     */
    @TableField(value = "robot_name")
    private String robotName;

    /**
     * 小车当前所在地
     */
    @TableField(value = "robot_location")
    private String robotLocation;

    /**
     * 小车状态
     */
    @TableField(value = "robot_state")
    private String robotState;

    /**
     * 小车当前订单
     */
    @TableField(value = "robot_order")
    private Long robotOrder;

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
        Robot other = (Robot) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRobotName() == null ? other.getRobotName() == null : this.getRobotName().equals(other.getRobotName()))
            && (this.getRobotLocation() == null ? other.getRobotLocation() == null : this.getRobotLocation().equals(other.getRobotLocation()))
            && (this.getRobotState() == null ? other.getRobotState() == null : this.getRobotState().equals(other.getRobotState()))
            && (this.getRobotOrder() == null ? other.getRobotOrder() == null : this.getRobotOrder().equals(other.getRobotOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRobotName() == null) ? 0 : getRobotName().hashCode());
        result = prime * result + ((getRobotLocation() == null) ? 0 : getRobotLocation().hashCode());
        result = prime * result + ((getRobotState() == null) ? 0 : getRobotState().hashCode());
        result = prime * result + ((getRobotOrder() == null) ? 0 : getRobotOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", robotName=").append(robotName);
        sb.append(", robotLocation=").append(robotLocation);
        sb.append(", robotState=").append(robotState);
        sb.append(", robotOrder=").append(robotOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}