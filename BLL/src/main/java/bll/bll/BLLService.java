package bll.bll;

import dal.dal.DALService;

public class BLLService {
    public String BLLService() {
        DALService d = new DALService();
        return "I'm BLL    " + d.Dal();
    }
}
