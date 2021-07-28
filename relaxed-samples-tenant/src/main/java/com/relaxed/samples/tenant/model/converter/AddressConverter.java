package com.relaxed.samples.tenant.model.converter;

import com.relaxed.samples.tenant.model.dto.AddressDTO;
import com.relaxed.samples.tenant.model.entity.Address;
import com.relaxed.samples.tenant.model.vo.AddressVO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 转换器
 * </p>
 *
 * @author yakir
 * @since 2021-07-28T16:57:52.865
 */
@Mapper
public interface AddressConverter {

	AddressConverter INSTANCE = Mappers.getMapper(AddressConverter.class);

	/**
	 * po -> vo
	 * @param address {@link Address}
	 * @return {@link AddressVO}
	 */
	AddressVO poToVo(Address address);

	/**
	 * dto -> po
	 * @param addressDTO {@link AddressDTO}
	 * @return {@link Address}
	 */
	Address dtoToPo(AddressDTO addressDTO);

	/**
	 * po -> vos
	 * @param addressProperties {@link List<Address>}
	 * @return {@link List<AddressVO>}
	 */
	List<AddressVO> poToVOs(List<Address> addressProperties);

}
