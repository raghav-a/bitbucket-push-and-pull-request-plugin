/*******************************************************************************
 * The MIT License
 * 
 * Copyright (C) 2019, CloudBees, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/

package io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.cloud;

import java.io.File;
import java.io.IOException;
import org.kohsuke.stapler.DataBoundConstructor;
import hudson.Extension;
import io.jenkins.plugins.bitbucketpushandpullrequest.action.BitBucketPPRAction;
import io.jenkins.plugins.bitbucketpushandpullrequest.cause.BitBucketPPRTriggerCause;
import io.jenkins.plugins.bitbucketpushandpullrequest.cause.pullrequest.cloud.BitBucketPPRPullRequestUpdatedCause;

public class BitBucketPPRPullRequestMergedActionFilter extends BitBucketPPRPullRequestActionFilter {

	@DataBoundConstructor
	public BitBucketPPRPullRequestMergedActionFilter() {
	}

	@Override
	public boolean shouldTriggerBuild(BitBucketPPRAction bitbucketAction) {
		return true;
	}

	@Override
	public BitBucketPPRTriggerCause getCause(File pollingLog, BitBucketPPRAction pullRequestAction) throws IOException {
		return new BitBucketPPRPullRequestUpdatedCause(pollingLog, pullRequestAction);
	}

	@Extension
	public static class ActionFilterDescriptorImpl extends BitBucketPPRPullRequestActionDescriptor {

		@Override
		public String getDisplayName() {
			return "Merged";
		}
	}

	@Override
	public String toString() {
		return "BitBucketPPRPullRequestMergedActionFilter [getDescriptor()=" + getDescriptor() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
