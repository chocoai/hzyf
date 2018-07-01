package com.cd.zjyf.management;

import com.cd.zjyf.management.bean.Response;
import com.cd.zjyf.management.bean.ResultCode;
import com.cd.zjyf.management.pojo.YlwsJbxx;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by li.mingyang on 2018/4/15.
 */
@RestController
@Api(description = "医疗机构相关接口")
@RequestMapping("/ylwsJbxx")
public class YlwsJbxxController {

    @GetMapping
    @ApiOperation(value = "根据id查询医疗机构", notes = "")
    public YlwsJbxx getUser(@ApiParam(value = "医疗机构id") String id)  throws Exception{
        return new YlwsJbxx();
    }

    @GetMapping("/conditions")
    @ApiOperation(value = "根据条件查询医疗机构")
    public List<YlwsJbxx> getUsersByCondition(YlwsJbxx ylwsJbxx) throws Exception{
        YlwsJbxx ylwsJbxx1 = new YlwsJbxx();
        YlwsJbxx ylwsJbxx2 = new YlwsJbxx();
        YlwsJbxx ylwsJbxx3 = new YlwsJbxx();
        ArrayList<YlwsJbxx> ylwsJbxxs = new ArrayList<>();
        ylwsJbxxs.add(ylwsJbxx1);
        ylwsJbxxs.add(ylwsJbxx2);
        ylwsJbxxs.add(ylwsJbxx3);
        return ylwsJbxxs;
    }

    @PostMapping
    @ApiOperation(value = "新增医疗机构")
    public Response getUser(@RequestBody YlwsJbxx ylwsJbxx) throws Exception{
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "删除医疗机构")
    public Response deleteUser(@PathVariable("ids") @ApiParam(value = "删除的医疗机构id数组") String[] ylwsJbxxIds) throws Exception{
        System.out.println("ylwsJbxxIds = " + ylwsJbxxIds);
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @PutMapping("/{id}")
    @ApiOperation("根据id修改医疗机构")
    public Response updateUser(@PathVariable("id") @ApiParam(value = "医疗机构id") String id, @RequestBody YlwsJbxx ylwsJbxx) throws Exception{
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @GetMapping(value = "/template")
    @ApiOperation("医疗机构批量导入模板下载")
    public Response templateDownload(HttpServletRequest request, HttpServletResponse response) {
        return new Response(0, ResultCode.SUCCESS, null);
    }

    @PostMapping(value = "/import")
    @ApiOperation("医疗机构批量导入")
    public Response importFile(@RequestParam(value = "file") @ApiParam("上传文件") MultipartFile file) {
        return new Response(0, ResultCode.SUCCESS, null);
    }
}
