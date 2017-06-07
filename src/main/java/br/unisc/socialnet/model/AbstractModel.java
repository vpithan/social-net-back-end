package br.unisc.socialnet.model;

import javax.persistence.Column;

public class AbstractModel {
    @Column(name = "create_at")
    private Long createAt;
    @Column(name = "update_at")
    private Long updateAt;

    
    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

}
