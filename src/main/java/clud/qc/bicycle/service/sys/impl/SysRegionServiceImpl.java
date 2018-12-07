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
    public SysRegionDO save(SysRegionDO sysRegionDO) {
        return sysRegionDAO.save(sysRegionDO);
    }

    @Override
    public List<SysRegionDO> batchSave(List<SysRegionDO> sysRegionDOList) {
        return sysRegionDAO.saveAll(sysRegionDOList);
    }

    @Override
    public List<SysRegionDO> queryAll() {
        return sysRegionDAO.findAll();
    }

}
