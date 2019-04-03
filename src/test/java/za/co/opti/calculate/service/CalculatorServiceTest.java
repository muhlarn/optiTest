package za.co.opti.calculate.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;
import za.co.opti.calculate.repository.CalculatorRepository;
import za.co.opti.calculate.service.impl.CalculatorServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest extends TestCase {
	
	Logger logger = LoggerFactory.getLogger(CalculatorServiceTest.class);

	@InjectMocks
	private CalculatorServiceImpl calculatorService;

	@Mock
	private CalculatorRepository calculatorRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void clear() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void testGetWomenAndChildrenPopulation() {

		try {
			// IF
			int womenCount = 450;
			int childrenCount = 33;
			int totalCount = 483;

			// given
			when(calculatorRepository.retrieveWomenChildrenPopulation(womenCount, childrenCount)).thenReturn(totalCount);

			// when
			int totalPopulation = calculatorService.getWomenChildrenPopulation(womenCount, childrenCount);

			// then
			verify(calculatorRepository, times(1)).retrieveWomenChildrenPopulation(womenCount, childrenCount);
			assertEquals(totalCount, totalPopulation);
		} catch (Exception e) {
			logger.error(e.getMessage());
			fail();
		}
	}

}
