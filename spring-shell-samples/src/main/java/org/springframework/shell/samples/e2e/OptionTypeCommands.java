/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.shell.samples.e2e;

import java.io.PrintWriter;

import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.standard.ShellComponent;

/**
 * Commands used for e2e test.
 *
 * @author Janne Valkealahti
 */
@ShellComponent
public class OptionTypeCommands extends BaseE2ECommands {

	@Bean
	public CommandRegistration testOptionTypeRegistration() {
		return CommandRegistration.builder()
			.command(REG, "option-type")
			.group(GROUP)
			.withOption()
				.longNames("arg1")
				.and()
			.withOption()
				.longNames("arg2")
				.type(String.class)
				.and()
			.withOption()
				.longNames("arg3")
				.type(int.class)
				.and()
			.withOption()
				.longNames("arg4")
				.label("MYLABEL")
				.and()
			.withTarget()
				.consumer(ctx -> {
					PrintWriter writer = ctx.getTerminal().writer();
					if (ctx.hasMappedOption("arg3")) {
						int v = ctx.getOptionValue("arg3");
						writer.append("arg3=" + Integer.toString(v) + "\n");
					}
					writer.flush();
				})
				.and()
			.build();
	}

}
