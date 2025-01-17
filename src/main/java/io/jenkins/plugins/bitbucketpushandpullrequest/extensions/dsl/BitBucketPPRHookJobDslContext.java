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


package io.jenkins.plugins.bitbucketpushandpullrequest.extensions.dsl;

import java.util.ArrayList;
import java.util.List;

import io.jenkins.plugins.bitbucketpushandpullrequest.BitBucketPPRTrigger;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.BitBucketPPRTriggerFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.cloud.BitBucketPPRPullRequestApprovedActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.cloud.BitBucketPPRPullRequestCreatedActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.cloud.BitBucketPPRPullRequestMergedActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.cloud.BitBucketPPRPullRequestTriggerFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.cloud.BitBucketPPRPullRequestUpdatedActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.server.BitBucketPPRPullRequestServerApprovedActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.server.BitBucketPPRPullRequestServerCreatedActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.server.BitBucketPPRPullRequestServerMergedActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.server.BitBucketPPRPullRequestServerTriggerFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.pullrequest.server.BitBucketPPRPullRequestServerUpdatedActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.repository.BitBucketPPRRepositoryPushActionFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.repository.BitBucketPPRRepositoryTriggerFilter;
import io.jenkins.plugins.bitbucketpushandpullrequest.filter.repository.BitBucketPPRServerRepositoryPushActionFilter;

import javaposse.jobdsl.dsl.Context;

public class BitBucketPPRHookJobDslContext implements Context {
  List<BitBucketPPRTriggerFilter> triggers = new ArrayList<>();

  public void repositoryPushAction(boolean triggerAlsoIfTagPush, boolean triggerAlsoIfNothingChanged, 
      String allowedBranches) {
    BitBucketPPRRepositoryPushActionFilter repositoryPushActionFilter =
      new BitBucketPPRRepositoryPushActionFilter(triggerAlsoIfTagPush, triggerAlsoIfNothingChanged, allowedBranches);
    BitBucketPPRRepositoryTriggerFilter repositoryTriggerFilter =
      new BitBucketPPRRepositoryTriggerFilter(repositoryPushActionFilter);
    triggers.add(repositoryTriggerFilter);
  }

  public void pullRequestApprovedAction(boolean onlyIfReviewersApproved) {
    BitBucketPPRPullRequestApprovedActionFilter pullRequestApprovedActionFilter =
      new BitBucketPPRPullRequestApprovedActionFilter(onlyIfReviewersApproved);
    BitBucketPPRPullRequestTriggerFilter pullRequestTriggerFilter =
      new BitBucketPPRPullRequestTriggerFilter(pullRequestApprovedActionFilter);
    triggers.add(pullRequestTriggerFilter);
  }

  public void pullRequestCreatedAction() {
    BitBucketPPRPullRequestCreatedActionFilter pullRequestCreatedActionFilter =
      new BitBucketPPRPullRequestCreatedActionFilter();
    BitBucketPPRPullRequestTriggerFilter pullRequestTriggerFilter =
      new BitBucketPPRPullRequestTriggerFilter(pullRequestCreatedActionFilter);
    triggers.add(pullRequestTriggerFilter);
  }

  public void pullRequestUpdatedAction() {
    BitBucketPPRPullRequestUpdatedActionFilter pullRequestUpdatedActionFilter =
      new BitBucketPPRPullRequestUpdatedActionFilter();
    BitBucketPPRPullRequestTriggerFilter pullRequestTriggerFilter =
      new BitBucketPPRPullRequestTriggerFilter(pullRequestUpdatedActionFilter);
    triggers.add(pullRequestTriggerFilter);
  }
  
  public void pullRequestMergedAction() {
    BitBucketPPRPullRequestMergedActionFilter pullRequestMegedActionFilter =
        new BitBucketPPRPullRequestMergedActionFilter();
    BitBucketPPRPullRequestTriggerFilter pullRequestTriggerFilter =
        new BitBucketPPRPullRequestTriggerFilter(pullRequestMegedActionFilter);
    triggers.add(pullRequestTriggerFilter);
  }

  public void repositoryServerPushAction(boolean triggerAlsoIfTagPush, boolean triggerAlsoIfNothingChanged, 
      String allowedBranches) {
    BitBucketPPRServerRepositoryPushActionFilter repositoryServerPushActionFilter =
        new BitBucketPPRServerRepositoryPushActionFilter(triggerAlsoIfTagPush, triggerAlsoIfNothingChanged, allowedBranches);
    BitBucketPPRRepositoryTriggerFilter repositoryServerTriggerFilter =
        new BitBucketPPRRepositoryTriggerFilter(repositoryServerPushActionFilter);
    triggers.add(repositoryServerTriggerFilter);
  }

  public void pullRequestServerApprovedAction(boolean onlyIfReviewersApproved) {
    BitBucketPPRPullRequestServerApprovedActionFilter pullRequestServerApprovedActionFilter =
        new BitBucketPPRPullRequestServerApprovedActionFilter(onlyIfReviewersApproved);
    BitBucketPPRPullRequestServerTriggerFilter pullRequestServerTriggerFilter =
        new BitBucketPPRPullRequestServerTriggerFilter(pullRequestServerApprovedActionFilter);
    triggers.add(pullRequestServerTriggerFilter);
  }

  public void pullRequestServerCreatedAction() {
    BitBucketPPRPullRequestServerCreatedActionFilter pullRequestServerCreatedActionFilter =
        new BitBucketPPRPullRequestServerCreatedActionFilter();
    BitBucketPPRPullRequestServerTriggerFilter pullRequestServerTriggerFilter =
        new BitBucketPPRPullRequestServerTriggerFilter(pullRequestServerCreatedActionFilter);
    triggers.add(pullRequestServerTriggerFilter);
  }

  public void pullRequestServerUpdatedAction() {
    BitBucketPPRPullRequestServerUpdatedActionFilter pullRequestUpdatedServerActionFilter =
        new BitBucketPPRPullRequestServerUpdatedActionFilter();
    BitBucketPPRPullRequestServerTriggerFilter pullRequestServerTriggerFilter =
        new BitBucketPPRPullRequestServerTriggerFilter(pullRequestUpdatedServerActionFilter);
    triggers.add(pullRequestServerTriggerFilter);
  }

  public void pullRequestServerMergedAction() {
    BitBucketPPRPullRequestServerMergedActionFilter pullRequestServerMegedActionFilter =
        new BitBucketPPRPullRequestServerMergedActionFilter();
    BitBucketPPRPullRequestServerTriggerFilter pullRequestServerTriggerFilter =
        new BitBucketPPRPullRequestServerTriggerFilter(pullRequestServerMegedActionFilter);
    triggers.add(pullRequestServerTriggerFilter);
  }
}
