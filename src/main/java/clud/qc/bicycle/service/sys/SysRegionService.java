package clud.qc.bicycle.service.sys;

import clud.qc.bicycle.entity.sys.SysRegionDO;

import java.util.List;

public interface SysRegionService {

    SysRegionDO save(SysRegionDO sysRegionDO);

    List<SysRegionDO> batchSave(List<SysRegionDO> sysRegionDOList);

    List<SysRegionDO> queryAll();

}
