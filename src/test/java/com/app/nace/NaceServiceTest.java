package com.app.nace;

import com.app.nace.domain.Nace;
import com.app.nace.repository.NaceRepository;
import com.app.nace.service.NaceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class NaceServiceTest {
    @Mock
    private NaceRepository naceRepository;

    private NaceService naceService;

    private Nace nace = new Nace(398481L, 1, "A", "", "AGRICULTURE, FORESTRY AND FISHING",
            "This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.",
            "", "", "", "A");
    @Before
    public void setup() {
        naceService = new NaceService(naceRepository);
    }
    @Test
    public void getNace_shouldReturnNace(){
        given(naceRepository.findById(398481L)).willReturn(java.util.Optional.ofNullable(nace));
        Nace nace1 = naceService.getNaceById(398481L);
        assertThat(nace1.getId().longValue()).isEqualTo(398481L);
    }
}
