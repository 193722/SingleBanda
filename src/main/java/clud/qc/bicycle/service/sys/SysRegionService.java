package clud.qc.bicycle.service.sys;

import clud.qc.bicycle.entity.sys.SysRegionDO;

import java.util.List;

public interface SysRegionService {

    void save(SysRegionDO sysRegionDO);

    void batchSave(List<SysRegionDO> sysRegionDOList);

}
