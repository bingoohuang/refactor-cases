package com.github.bingoohuang.legacycode.workflow;

import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class Workflow {
    private ErrorProcessingService errorProcessingService;
    private TWorkBillcode workbillcode;
    private Flow flow;

    public void doService() {
        List<TWorkFlowwork> wfwList = errorProcessingService.
                findWorkFlowworkByWorkType("7", workbillcode.getId() + "");
        boolean flag = false;
        if (wfwList != null && wfwList.size() > 0) {
            for (int i = 0; i < wfwList.size(); i++) {
                TWorkFlowwork wfw = wfwList.get(i);
                if (wfw != null) {//当前待办是原件校验并且如果已经结束了则激活原件校验待办
                    if (wfw.getStatus() != null && !"".equals(wfw.getStatus())) {
                        if ("1".equals(wfw.getStatus())) {
                            flag = true;
                            break;
                        }
                    }

                }
            }
            if (!flag) {//如果原件校验待办都结束了，则产生一条原件校验待办
                TWorkBillcode wb = errorProcessingService.
                        findWorkBillcodeByParameters(flow.getBussid(), flow.getBusstype());
                wb.setIsmatchpage("1");
                errorProcessingService.updateWorkBillcode(wb);
            }
        }
    }

    /*
原作者对java的基本语法不熟；// 循环语句很拙劣，可能是从C转入没多久
之前系统的培训过或者认真看过相关编码的书； // 大量的魔幻数字，wfwList.size()==0 而不是isEmpty()
代码量不大。// 这个代码片段不长，却非常费解。而且代码层次感不强，各种高层的接口和底层的接口杂糅在一起

老规矩，简单点评一下这个代码：唉~~~~~~~
魔幻数字"7"，“1”
大量的空对象判断。 这个不是表示严谨，而是代码设计有问题
极深的if else 嵌套，主要都是极端的头重脚轻形式的if 语句
首先，if(wfwList!=null&&wfwList.size()>0){ 超级的头重脚轻，采用return 直接返回
其次，for(int i=0;i<wfwList.size();i++){   TWorkFlowwork wfw=wfwList.get(i);  可以利用java的语法甜头，或者说是惯用法，替换为for (TWorkFlowwork wfw : wfwList)
然后，if (wfw!=null) 又可以用卫语句处理，不过这里不能使用return直接返回，而是应该用continue
最后，后面if status的判断实际都可以合并起来
 if(wfw.getStatus()!=null&&!"".equals(wfw.getStatus())
				&& "1".equals(wfw.getStatus())){
						flag=true;
						break;
			}
仔细分析，不难发现wfw.getStatus()!=null&&!"".equals(wfw.getStatus()) 根本是多余的。
于是代码变成这个样子
     */

    public void doServiceV1() {
        List<TWorkFlowwork> wfwList = errorProcessingService.
                findWorkFlowworkByWorkType("7", workbillcode.getId() + "");
        if (wfwList == null || wfwList.size() == 0) {
            return;
        }

        boolean flag = false;
        for (TWorkFlowwork wfw : wfwList) {
            //当前待办是原件校验并且如果已经结束了则激活原件校验待办
            if (wfw == null) continue;

            if ("1".equals(wfw.getStatus())) {
                flag = true;
                break;
            }
        }

        if (!flag) {//如果原件校验待办都结束了，则产生一条原件校验待办
            TWorkBillcode wb = errorProcessingService.
                    findWorkBillcodeByParameters(flow.getBussid(), flow.getBusstype());
            wb.setIsmatchpage("1");
            errorProcessingService.updateWorkBillcode(wb);
        }
    }
}
