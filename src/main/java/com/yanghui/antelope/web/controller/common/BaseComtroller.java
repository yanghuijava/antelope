package com.yanghui.antelope.web.controller.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanghui.antelope.common.config.AntelopeConfigProperties;
import com.yanghui.antelope.common.constant.Constant;
import com.yanghui.antelope.common.utils.DateUtil;
import com.yanghui.antelope.common.utils.HttpKit;
import com.yanghui.antelope.common.utils.TransformationUtil;
import com.yanghui.antelope.domain.system.User;
import com.yanghui.antelope.web.vo.PageResult;
import com.yanghui.antelope.web.vo.Wrapper;

public abstract class BaseComtroller {
	

	public final static Logger logger = LoggerFactory.getLogger(BaseComtroller.class);
	
	@Autowired
	protected AntelopeConfigProperties antelopeConfigProperties;

	/**
	 * 上传文件 返回文件的相对路径
	 * 
	 * @param file
	 * @return
	 */
	protected String upload(MultipartFile file) {
		BufferedOutputStream bos = null;
		try {
			// 截取上传文件的文件名
			String uploadFilePath = file.getOriginalFilename();
			// 截取上传文件的文件名
			String uploadFileName = uploadFilePath.substring(
					uploadFilePath.lastIndexOf('\\') + 1,
					uploadFilePath.indexOf('.'));
			// 截取上传文件的后缀
			String uploadFileSuffix = uploadFilePath.substring(
					uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
			
			String datePath = DateUtil.format(new Date(),"yyyyMMdd");
			File uploadBasePath = new File(this.antelopeConfigProperties.getFileuploadPath() + File.separator + datePath);
			if(!uploadBasePath.exists()){
				uploadBasePath.mkdirs();
			}
			String realFileRelativePath = datePath + File.separator + 
					UUID.randomUUID().toString().replaceAll("-","") + "-" + uploadFileName + "." + uploadFileSuffix;
			File realFilePath = new File(this.antelopeConfigProperties.getFileuploadPath() + File.separator +
					realFileRelativePath);
			bos = new BufferedOutputStream(new FileOutputStream(realFilePath));
			byte[] bytes = file.getBytes();
			bos.write(bytes, 0, bytes.length);
			return realFileRelativePath;
		} catch (IOException e) {
			logger.error("文件上传发生异常：{}", e);
		}finally{
			try {
				if(bos != null)bos.close();
			} catch (IOException e) {
				logger.error("关闭文件上传流发生异常：{}", e);
			}
		}
		return "";
	}
	
	/**
	 * 下载文件
	 * @param filePath 文件绝对路径
	 */
	protected void download(String filePath) {
		HttpServletResponse response = HttpKit.getResponse();
		String fileName = filePath.split("-")[1];
		response.setHeader("content-type", "application/octet-stream;charset=utf-8");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
	    BufferedInputStream bis = null;
	    OutputStream os = null;
	    try {
	      os = response.getOutputStream();
	      bis = new BufferedInputStream(new FileInputStream(filePath));
	      int i = bis.read(buff);
	      while (i != -1) {
	        os.write(buff, 0, buff.length);
	        os.flush();
	        i = bis.read(buff);
	      }
	    } catch (IOException e) {
	      logger.error("下载文件发生异常：{}",e);
	    } finally {
			try {
				if(bis != null)bis.close();
			} catch (IOException e) {
				logger.error("下载文件关闭发生异常：{}",e);
			}
	    }
	}
	
	protected String getFileNameFromPath(String path) {
		String[] ps = path.split("-");
		return ps[1];
	}
	
	protected <T> T saveGet(Map<String, Object> params, Class<T> clz)
			throws Exception {
		User user = (User) HttpKit.getRequest().getSession()
				.getAttribute(Constant.USER_SESSION_NAME);
		T t = TransformationUtil.toObject(params, clz);
		Field f = clz.getSuperclass().getDeclaredField("createBy");
		f.setAccessible(true);
		f.set(t, user.getId());
		f.setAccessible(false);
		f = clz.getSuperclass().getDeclaredField("updateBy");
		f.setAccessible(true);
		f.set(t, user.getId());
		f.setAccessible(false);
		return t;
	}

	protected <T> T updateGet(Map<String, Object> params, Class<T> clz)
			throws Exception {
		User user = (User) HttpKit.getRequest().getSession()
				.getAttribute(Constant.USER_SESSION_NAME);
		T t = TransformationUtil.toObject(params, clz);
		Field f = clz.getSuperclass().getDeclaredField("createBy");
		f.setAccessible(true);
		f.set(t, null);
		f.setAccessible(false);

		f = clz.getSuperclass().getDeclaredField("createTime");
		f.setAccessible(true);
		f.set(t, null);
		f.setAccessible(false);

		f = clz.getSuperclass().getDeclaredField("updateBy");
		f.setAccessible(true);
		f.set(t, user.getId());
		f.setAccessible(false);
		return t;
	}

	protected Map<String, Object> edatagridSuccessResult(
			Map<String, Object> map, Serializable id) {
		map.put("id", id);
		map.put("success", true);
		map.put("message", Constant.SUCCESS);
		map.put("isError", false);
		return map;
	}

	protected Map<String, Object> edatagridFailResult(Map<String, Object> map) {
		map.put("success", false);
		map.put("message", Constant.FAIL);
		map.put("isError", true);
		return map;
	}

	protected Wrapper<String> successWrapper() {
		return Wrapper.wrap(Constant.SUCCESS, true);
	}

	protected Wrapper<?> failWrapper() {
		return Wrapper.wrap(Constant.FAIL, true);
	}

	protected <T> PageResult<T> createPage(Pagination pagination, List<T> data) {
		PageResult<T> page = new PageResult<T>();
		page.setTotal(pagination.getTotal());
		page.setRows(data);
		return page;
	}

	protected <T, K> PageResult<K> createPage(Pagination pagination,
			List<T> data, Class<K> clz) throws Exception {
		PageResult<K> page = new PageResult<K>();
		List<K> klist = new ArrayList<K>();
		for (T t : data) {
			K k = clz.newInstance();
			BeanUtils.copyProperties(t, k);
			klist.add(k);
		}
		page.setTotal(pagination.getTotal());
		page.setRows(klist);
		return page;
	}
}
