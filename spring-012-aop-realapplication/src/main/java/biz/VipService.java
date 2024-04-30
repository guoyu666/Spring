package biz;

import org.springframework.stereotype.Service;

@Service("vipService")
public class VipService {
    public void saveVip(){
        System.out.println("新增会员用户...");
    }

    public void deleteVip(){
        System.out.println("删除会员用户...");
    }
}
