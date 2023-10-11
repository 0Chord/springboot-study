package hello.external;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV2 {

	public static void main(String[] args) {
		for (String arg : args) {
			log.info("arg {}",arg);
		}

		ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
		log.info("SourceArgs={}", List.of(applicationArguments.getSourceArgs()));
		log.info("NonOptionArgs={}",applicationArguments.getNonOptionArgs());
		log.info("OptionsNames={}",applicationArguments.getOptionNames());

		Set<String> optionNames = applicationArguments.getOptionNames();
		for (String optionName : optionNames) {
			log.info("option arg {}={}", optionName, applicationArguments.getOptionValues(optionName));
		}
	}
}
