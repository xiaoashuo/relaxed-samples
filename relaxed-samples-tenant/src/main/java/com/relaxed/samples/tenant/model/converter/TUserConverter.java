package com.relaxed.samples.tenant.model.converter;

import com.relaxed.samples.tenant.model.dto.TUserDTO;
import com.relaxed.samples.tenant.model.entity.TUser;
import com.relaxed.samples.tenant.model.vo.TUserVO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 转换器
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T16:57:52.841
 */
@Mapper
public interface TUserConverter {

	TUserConverter INSTANCE = Mappers.getMapper(TUserConverter.class);

	/**
	 * po -> vo
	 * @param tUser {@link TUser}
	 * @return {@link TUserVO}
	 */
	TUserVO poToVo(TUser tUser);

	/**
	 * dto -> po
	 * @param tUserDTO {@link TUserDTO}
	 * @return {@link TUser}
	 */
	TUser dtoToPo(TUserDTO tUserDTO);

	/**
	 * po -> vos
	 * @param tUserProperties {@link List<TUser>}
	 * @return {@link List<TUserVO>}
	 */
	List<TUserVO> poToVOs(List<TUser> tUserProperties);

}
