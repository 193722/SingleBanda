package clud.qc.bicycle.service.sys.impl;

import clud.qc.bicycle.dao.sys.SysRegionDAO;
import clud.qc.bicycle.entity.sys.SysRegionDO;
import clud.qc.bicycle.service.sys.SysRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRegionServiceImpl implements SysRegionService {

    @Autowired
    private SysRegionDAO sysRegionDAO;

    @Override
    public void save(SysRegionDO sysRegionDO) {
        sysRegionDAO.save(sysRegionDO);
    }

    @Override
    public void batchSave(List<SysRegionDO> sysRegionDOList) {
        sysRegionDAO.save(sysRegionDOList);
    }
}
