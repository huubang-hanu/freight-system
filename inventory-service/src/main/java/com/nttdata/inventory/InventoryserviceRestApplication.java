package com.nttdata.inventory;

import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 */
@LoginConfig(authMethod = "MP-JWT")
@ApplicationPath("/inventory")
@DeclareRoles({ "manager", "USER" })
public class InventoryserviceRestApplication extends Application {
}
