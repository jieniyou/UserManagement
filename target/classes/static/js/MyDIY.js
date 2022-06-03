layui.use(['laydate'], function(){
    laydate = layui.laydate;//日期插件

    //以上模块根据需要引入
    //



    var start = {
        min: laydate.now()
        ,max: '2099-06-16 23:59:59'
        ,istoday: false
        ,choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };

    var end = {
        min: laydate.now()
        ,max: '2099-06-16 23:59:59'
        ,istoday: false
        ,choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };

    document.getElementById('LAY_demorange_s').onclick = function(){
        start.elem = this;
        laydate(start);
    }
    document.getElementById('LAY_demorange_e').onclick = function(){
        end.elem = this
        laydate(end);
    }

});

//批量删除提交
function delAll () {
    layer.confirm('确认要删除吗？',function(index){
        //捉到所有被选中的，发异步进行删除
        layer.msg('删除成功', {icon: 1});
    });
}
/*用户-添加*/
function member_add(title,url,w,h){
    x_admin_show(title,url,w,h)
}
/*用户-查看*/
function member_show(title,url,userName,email,gender,identity,w,h){
    my_show(title,url,userName,email,gender,identity,w,h)
}

/*用户-停用*/
// ,userName,password,gender,email,birth,identity
function member_stop(obj,id,status){
    id=id.replace("\"","").replace("\"","");
    // userName=userName.replace("\"","").replace("\"","");
    // password=password.replace("\"","").replace("\"","");
    // gender=gender.replace("\"","").replace("\"","");
    // email=email.replace("\"","").replace("\"","");
    // birth=birth.replace("\"","").replace("\"","");
    // identity=identity.replace("\"","").replace("\"","");
    // status=status.replace("\"","").replace("\"","");
    layer.confirm('确认要停用吗？',function(index){
        //发异步把用户状态进行更改
        $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,'
            +id+','/*+userName+','+password+','+gender+','+email+','+birth+','+identity+','*/+status+','+
            ')" href="javascript:;" title="启用"><i class="layui-icon">&#xe62f;</i></a>');
        $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-disabled layui-btn-mini">已停用</span>');
        $(obj).remove();
        $.ajax({
            url:  '/user/edit',
            isAysn: false,
            type: 'get',
            contentType: 'application/json',
            data: {id/*,userName,password,gender,email,birth,identity*/,status}
        });
        layer.msg('已停用!',{icon: 5,time:1000});
    });
}

/*用户-启用*/
// ,userName,password,gender,email,birth,identity
function member_start(obj,id,status){
    id=id.replace("\"","").replace("\"","");
    // userName=userName.replace("\"","").replace("\"","");
    // password=password.replace("\"","").replace("\"","");
    // gender=gender.replace("\"","").replace("\"","");
    // email=email.replace("\"","").replace("\"","");
    // birth=birth.replace("\"","").replace("\"","");
    // identity=identity.replace("\"","").replace("\"","");
    status=status.replace("\"","").replace("\"","");
    layer.confirm('确认要启用吗？',function(index){
        //发异步把用户状态进行更改
        $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,'
            +id+','/*+userName+','+password+','+gender+','+email+','+birth+','+identity+','*/+status+','+
            ')" href="javascript:;" title="停用"><i class="layui-icon">&#xe601;</i></a>');
        $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>');
        $(obj).remove();
        layer.msg('已启用!',{icon: 6,time:1000});
        $.ajax({
            url:  '/user/edit',
            isAysn: false,
            type: 'get',
            contentType: 'application/json',
            data: {id/*,userName,password,gender,email,birth,identity*/,status}
        });
    });
}
// 用户-编辑
function member_edit (title,url,id,userName,password,gender,email,birth,identity,status,w,h) {
    my_show(title,url,id,userName,password,gender,email,birth,identity,status,w,h);
}
/*密码-修改*/
function member_password(title,url,id,w,h){
    my_show(title,url,w,h);
}

/*用户-删除*/
/**
 * function member_del(obj,id){
 *         layer.confirm('确认要删除吗？',function(index){
 *
 *             console.log("obj==>>>"+obj);
 *             //发异步删除数据
 *             $(obj).parents("tr").remove();
 *             layer.msg('已删除!',{icon:1,time:1000});
 *         });
 *     }
 *
 *     function check(hitOrderId) {
 *         console.log("hitOrderId=====>"+hitOrderId);
 *         layer.confirm("审核后确定该订单业绩归属", {
 *             icon: 3,
 *             title: "系统提示",
 *             btn: ['确认', '拒绝']
 *         }, function (index) {
 *             //审核通过
 *             layer.close(index);
 *             var data = {hitOrderId: hitOrderId,auditStatus:2};
 *             $.operate.post(prefix + "/user/del", data);
 *         }, function (index) {
 *             //审核拒绝
 *             layer.close(index);
 *             var data = {hitOrderId: hitOrderId,auditStatus:3};
 *             $.operate.post(prefix + "/user/del", data);
 *         });
 *     }
 */

function member_del(obj,id) {
    console.log(id)
    let lock=false;//默认未锁定
    let myconfirm=layer.confirm('确认要删除吗？',{btn: ['确定','取消']},function(index){
            console.log(lock);
            if(!lock){
                lock=true;//锁定
                //发送ajax
                $.ajax({
                    url:  '/user/del',
                    isAysn: false,
                    type: 'get',
                    contentType: 'application/json',
                    data: {id},
                    success: function (result) {

                        let res=$.parseJSON(result);
                        let code=res.code;

                        if(code==0){
                            layer.msg("已删除!");
                            window.location.reload();
                        }else{
                            layer.msg(res.msg);
                        }
                    }
                });
                $(obj).parents("tr").remove();
            }
            layer.close(myconfirm);
        }
        ,function(index){
            console.log('fail');
        });
}

