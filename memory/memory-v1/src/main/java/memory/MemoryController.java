package memory;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemoryController {

	private final MemoryFinder memoryFinder;


	@GetMapping("/memory")
	public Memory system() {
		Memory memory = memoryFinder.get();
		log.info("memory={}",memory);
		List<Integer> intList = new LinkedList<>();
		return memory;
	}
}
