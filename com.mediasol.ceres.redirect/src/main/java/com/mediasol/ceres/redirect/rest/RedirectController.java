/*
 * Copyright (C) 2017 MEDIA SOLUTIONS
 * All Rights Reserved.  No use, copying or distribution of this
 * work may be made except in accordance with a valid license
 * agreement from MEDIA SOLUTIONS. This notice must be
 * included on all copies, modifications and derivatives of this
 * work.
 *
 * MEDIA SOLUTIONS MAKES NO REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESSED OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 * MEDIA SOLUTIONS SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES
 */
package com.mediasol.ceres.redirect.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Jiří Škoda, jiri.skoda@media-sol.com, MEDIA SOLUTIONS
 */
@RestController
public class RedirectController {

	@Value("${redirect.port}")
	private String port;

	@Value("${redirect.host:localhost}")
	private String host;

	@GetMapping("/")
	public RedirectView localRedirect() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://" + host + ":" + port);
		return redirectView;
	}

}
