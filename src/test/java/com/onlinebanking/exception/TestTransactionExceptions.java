package com.onlinebanking.exception;

import static com.onlinebanking.utils.TestUtils.currentTest;
import static com.onlinebanking.utils.TestUtils.exceptionTestFile;
import static com.onlinebanking.utils.TestUtils.testReport;
import static com.onlinebanking.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.onlinebanking.OnlineBankingApplication;
import com.onlinebanking.controller.TransactionController;
import com.onlinebanking.dto.TransactionDTO;
import com.onlinebanking.service.TransactionService;
import com.onlinebanking.utils.MasterData;

@WebMvcTest(TransactionController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = OnlineBankingApplication.class)
public class TestTransactionExceptions {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TransactionService transactionService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testCreateTransactionInvalidDataException() throws Exception {
		TransactionDTO transactionDTO = MasterData.getTransactionDTO();
		transactionDTO.setAmount(null);
		transactionDTO.setId(null);
		transactionDTO.setType(null);
		transactionDTO.setUser(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transactions")
				.content(MasterData.asJsonString(transactionDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseBody = result.getResponse().getContentAsString();
		TransactionDTO transactionDTOResponse = new Gson().fromJson(responseBody, TransactionDTO.class);
		yakshaAssert(currentTest(), (transactionDTOResponse == null ? "true" : "false"), exceptionTestFile);
	}

	@Test
	public void testUpdateTransactionInvalidDataException() throws Exception {
		TransactionDTO transactionDTO = MasterData.getTransactionDTO();
		transactionDTO.setAmount(null);
		transactionDTO.setId(null);
		transactionDTO.setType(null);
		transactionDTO.setUser(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/transactions/" + transactionDTO.getId())
				.content(MasterData.asJsonString(transactionDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseBody = result.getResponse().getContentAsString();
		TransactionDTO transactionDtoResponse = new Gson().fromJson(responseBody, TransactionDTO.class);
		yakshaAssert(currentTest(), (transactionDtoResponse == null ? "true" : "false"), exceptionTestFile);
	}

	@Test
	public void testUpdateTransactionByIdResourceNotFoundException() throws Exception {
		TransactionDTO transactionDTO = MasterData.getTransactionDTO();
		transactionDTO.setId((long) -10);
		transactionDTO.setAmount(null);
		transactionDTO.setType(null);
		transactionDTO.setUser(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/transactions/" + transactionDTO.getId())
				.content(MasterData.asJsonString(transactionDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseBody = result.getResponse().getContentAsString();
		TransactionDTO transactionDTOResponse = new Gson().fromJson(responseBody, TransactionDTO.class);
		yakshaAssert(currentTest(), (transactionDTOResponse == null ? "true" : "false"), exceptionTestFile);
	}

	@Test
	public void testGetTransactionByIdResourceNotFoundException() throws Exception {
		TransactionDTO transactionDTO = MasterData.getTransactionDTO();
		transactionDTO.setId((long) -10);

		GlobalExceptionHandler.ErrorResponse exResponse = new GlobalExceptionHandler.ErrorResponse(
				HttpStatus.BAD_REQUEST.value(), "" + transactionDTO.getId());

		when(this.transactionService.getTransactionById(transactionDTO.getId())).thenThrow(
				new ResourceNotFoundException("Transaction", "Trnsaction not found with id: ", transactionDTO.getId()));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/" + transactionDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testDeleteTransactionByIdResourceNotFoundException() throws Exception {
		TransactionDTO transactionDTO = MasterData.getTransactionDTO();
		transactionDTO.setId((long) -10);
		GlobalExceptionHandler.ErrorResponse exResponse = new GlobalExceptionHandler.ErrorResponse(
				HttpStatus.BAD_REQUEST.value(), "" + transactionDTO.getId());

		when(this.transactionService.deleteTransaction(transactionDTO.getId())).thenThrow(new ResourceNotFoundException(
				"Transaction", "Transaction not found with id: ", transactionDTO.getId()));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/transactions/" + transactionDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testSearchTransactionByBogusUserName() throws Exception {
		TransactionDTO transactionDTO = MasterData.getTransactionDTO();

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/transactions/search?type=" + transactionDTO.getType()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), (result.getResponse().getContentAsString().contains("") ? "true" : "false"),
				exceptionTestFile);

	}
}
