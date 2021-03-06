/*
 * Copyright 2014 Shazam Entertainment Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.shazam.fork.runner;

import com.android.ddmlib.IDevice;
import com.android.ddmlib.testrunner.IRemoteAndroidTestRunner;
import com.shazam.fork.batch.tasks.TestTask;

import javax.annotation.Nullable;

public class TestRunParameters {
	private final TestTask test;
	private final String testPackage;
	private final String testRunner;
	private final boolean isCoverageEnabled;
	private final IRemoteAndroidTestRunner.TestSize testSize;
	private final int testOutputTimeout;
	private final IDevice deviceInterface;
	private final String applicationPackage;

	public TestTask getTest() {
		return test;
	}

	public String getTestPackage() {
		return testPackage;
	}

	public String getTestRunner() {
		return testRunner;
	}

	@Nullable
	public IRemoteAndroidTestRunner.TestSize getTestSize() {
		return testSize;
	}

	public int getTestOutputTimeout() {
		return testOutputTimeout;
	}

	public IDevice getDeviceInterface() {
		return deviceInterface;
	}

	public boolean isCoverageEnabled(){
		return isCoverageEnabled;
	}

	public String getApplicationPackage() {
		return applicationPackage;
	}

	public static class Builder {
		private TestTask test;
		private String testPackage;
		private String testRunner;
		private boolean isCoverageEnabled;
		private IRemoteAndroidTestRunner.TestSize testSize;
		private IDevice deviceInterface;
		private int testOutputTimeout;
		private String applicationPackage;

		public static Builder testRunParameters() {
			return new Builder();
		}

		public Builder withTest(TestTask test) {
			this.test = test;
			return this;
		}

		public Builder withTestPackage(String testPackage) {
			this.testPackage = testPackage;
			return this;
		}

		public Builder withTestRunner(String testRunner) {
			this.testRunner = testRunner;
			return this;
		}

		public Builder withTestSize(IRemoteAndroidTestRunner.TestSize testSize) {
			this.testSize = testSize;
			return this;
		}

		public Builder withTestOutputTimeout(int testOutputTimeout) {
			this.testOutputTimeout = testOutputTimeout;
			return this;
		}

		public Builder withDeviceInterface(IDevice deviceInterface) {
			this.deviceInterface = deviceInterface;
			return this;
		}

		public Builder withCoverageEnabled(boolean isCoverageEnabled){
			this.isCoverageEnabled = isCoverageEnabled;
			return this;
		}

		public Builder withApplicationPackage(String applicationPackage) {
			this.applicationPackage = applicationPackage;
			return this;
		}

		public TestRunParameters build() {
			return new TestRunParameters(this);
		}
	}

	private TestRunParameters(Builder builder) {
		test = builder.test;
		testPackage = builder.testPackage;
		testRunner = builder.testRunner;
		testSize = builder.testSize;
		testOutputTimeout = builder.testOutputTimeout;
		deviceInterface = builder.deviceInterface;
		isCoverageEnabled = builder.isCoverageEnabled;
		this.applicationPackage = builder.applicationPackage;
	}
}
