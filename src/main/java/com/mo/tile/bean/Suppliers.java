package com.mo.tile.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName suppliers
 */
@Data
public class Suppliers implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table suppliers
     *
     * @mbg.generated Thu Jan 21 22:07:47 CST 2021
     */
    private static final long serialVersionUID = 1L;
    /**
     * @mbg.generated Thu Jan 21 22:07:47 CST 2021
     */
    private String supplier_id;
    /**
     *
     *
     * @mbg.generated Thu Jan 21 22:07:47 CST 2021
     */
    private String supplier_material;
    /**
     *
     *
     * @mbg.generated Thu Jan 21 22:07:47 CST 2021
     */
    private String supplier_name;
    /**
     *
     *
     * @mbg.generated Thu Jan 21 22:07:47 CST 2021
     */
    private String supplier_header;
    /**
     *
     *
     * @mbg.generated Thu Jan 21 22:07:47 CST 2021
     */
    private String supplier_phone;
    /**
     *
     *
     * @mbg.generated Thu Jan 21 22:07:47 CST 2021
     */
    private String supplier_address;

    /**
     * @mbg.generated
     */
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
        Suppliers other = (Suppliers) that;
        return (this.getSupplier_id() == null ? other.getSupplier_id() == null : this.getSupplier_id().equals(other.getSupplier_id()))
                && (this.getSupplier_material() == null ? other.getSupplier_material() == null : this.getSupplier_material().equals(other.getSupplier_material()))
                && (this.getSupplier_name() == null ? other.getSupplier_name() == null : this.getSupplier_name().equals(other.getSupplier_name()))
                && (this.getSupplier_header() == null ? other.getSupplier_header() == null : this.getSupplier_header().equals(other.getSupplier_header()))
                && (this.getSupplier_phone() == null ? other.getSupplier_phone() == null : this.getSupplier_phone().equals(other.getSupplier_phone()))
                && (this.getSupplier_address() == null ? other.getSupplier_address() == null : this.getSupplier_address().equals(other.getSupplier_address()));
    }

    /**
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSupplier_id() == null) ? 0 : getSupplier_id().hashCode());
        result = prime * result + ((getSupplier_material() == null) ? 0 : getSupplier_material().hashCode());
        result = prime * result + ((getSupplier_name() == null) ? 0 : getSupplier_name().hashCode());
        result = prime * result + ((getSupplier_header() == null) ? 0 : getSupplier_header().hashCode());
        result = prime * result + ((getSupplier_phone() == null) ? 0 : getSupplier_phone().hashCode());
        result = prime * result + ((getSupplier_address() == null) ? 0 : getSupplier_address().hashCode());
        return result;
    }

    /**
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplier_id=").append(supplier_id);
        sb.append(", supplier_material=").append(supplier_material);
        sb.append(", supplier_name=").append(supplier_name);
        sb.append(", supplier_header=").append(supplier_header);
        sb.append(", supplier_phone=").append(supplier_phone);
        sb.append(", supplier_address=").append(supplier_address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}