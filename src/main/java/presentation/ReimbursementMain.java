package presentation;

import exception.ApplicationException;
import io.javalin.Javalin;
import pojo.EmployeePojo;
import pojo.ErrorPojo;
import pojo.ReimbursementPojo;
import pojo.UsersPojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ManagerService;
import service.ManagerServiceImpl;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;
import service.ShoeService;
import service.ShoeServiceImpl;
import service.UsersService;
import service.UsersServiceImpl;

public class ReimbursementMain {
	public static void main(String[] args) {

		ReimbursementService reimbursementService = new ReimbursementServiceImpl();
		EmployeeService employeeService = new EmployeeServiceImpl();
		ManagerService managerService = new ManagerServiceImpl();
		UsersService usersService = new UsersServiceImpl();
		ShoeService shoeService = new ShoeServiceImpl();

		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(9090);

		// http://localhost:9090/hello
		server.get("hello", (ctx) -> {
			// tell here what to do when the hello endpoint is requested for
			System.out.println("Hello endpoint is requested!!");
			ctx.result("HELLO ENDPOINT IS REQUESTED!!");

		});

		// get endpoint to fetch all requests
		server.get("api/reimbursements", (ctx) -> {
			ctx.json(reimbursementService.getAllRequests());
		});

		// get endpoint to fetch one request
		server.get("api/reimbursements/{bid}", (ctx) -> {
			ctx.json(reimbursementService.getARequest(Integer.parseInt(ctx.pathParam("bid"))));

		});
		// post endpoint to add request
		server.post("api/reimbursements", (ctx) -> {
			ReimbursementPojo returnReimbursementPojo = reimbursementService
					.addRequest(ctx.bodyStreamAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbursementPojo);
		});
		// put endpoint to update request
		server.put("api/reimbursements/update", (ctx) -> {
			ReimbursementPojo returnReimbursementPojo = reimbursementService.updateRequest(ctx.bodyStreamAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbursementPojo);
		});
		// put endpoint to update a request
//				server.put("api/reimbursements/{bid}/update", (ctx) -> {
//					reimbursementService.updateARequest(Integer.parseInt(ctx.pathParam("bid")));
//					
//				});
		
		// delete endpoint to delete a request
		server.delete("api/reimbursements/{bid}", (ctx) -> {
			reimbursementService.deleteRequest(Integer.parseInt(ctx.pathParam("bid")));
		});

		// put endpoint to deny request
		server.put("api/reimbursements/approve/false", (ctx) -> {
			System.out.println("Put endpoint called: " + ctx.body());
			ReimbursementPojo returnReimbursementPojo = reimbursementService
					.denyRequest(ctx.bodyAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbursementPojo);
		});

		// put endpoint to approve request
		server.put("api/reimbursements/approve/true", (ctx) -> {
			System.out.println("Put endpoint called: " + ctx.body());
			ReimbursementPojo returnReimbursementPojo = reimbursementService
					.approveRequest(ctx.bodyAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbursementPojo);

		});

		// get endpoint to fetch all employee requests
		server.get("api/reimbursements/employee/{emp}", (ctx) -> {
			System.out.println("Employee Reimbursements endpoint is requested!!");
			ctx.json(reimbursementService.getAllEmpRequests(Integer.parseInt(ctx.pathParam("emp"))));
		});

		// get endpoint to get all employees
		server.get("api/manager", (ctx) -> {
			ctx.json(managerService.getAllEmployees());
		});

		// get endpoint to get all employees
		server.get("api/manager/employees", (ctx) -> {
			ctx.json(managerService.getAllEmployees());
		});

		// get endpoint to fetch all shoes
		server.get("api/shoes", (ctx) -> {
			ctx.json(shoeService.getAllShoes());
		});
		// get endpoint to fetch all pending requests
		server.get("api/reimbursements/status/false", (ctx) -> {
			System.out.println("Pending Reimbursements endpoint is requested!!");
			ctx.json(reimbursementService.getAllPendingRequests());
		});
		// get endpoint to fetch all resolved requests
		server.get("api/reimbursements/status/true", (ctx) -> {
			System.out.println("Resolved Reimbursements endpoint is requested!!");
			ctx.json(reimbursementService.getAllResolvedRequests());
		});

		// get endpoint to fetch all resolved for one employee
		server.get("api/reimbursements/employee/{emp}/status/true", (ctx) -> {
			System.out.println("Employee Resolved Reimbursements endpoint is requested!!");
			ctx.json(reimbursementService.getAllEmpResolvedRequests(Integer.parseInt(ctx.pathParam("emp"))));
		});

		// get endpoint to fetch all resolved for one employee
		server.get("api/employee/{emp}/reimbursement/status/true", (ctx) -> {
			System.out.println("Employee Resolved Reimbursements endpoint is requested!!");
			ctx.json(reimbursementService.getAllEmpResolvedRequests(Integer.parseInt(ctx.pathParam("emp"))));
		});

		// get endpoint to fetch all pending for one employee
		server.get("api/reimbursements/employee/{emp}/status/false", (ctx) -> {
			System.out.println("Employee Pending Reimbursements endpoint is requested!!");
			ctx.json(reimbursementService.getAllEmpPendingRequests(Integer.parseInt(ctx.pathParam("emp"))));
		});

		// get endpoint to fetch all pending for one employee
		server.get("api/employee/{emp}/reimbursement/status/false", (ctx) -> {
			System.out.println("Employee Pending Reimbursements endpoint is requested!!");
			ctx.json(reimbursementService.getAllEmpPendingRequests(Integer.parseInt(ctx.pathParam("emp"))));
		});
		// get endpoint to fetch all request for one employee
				server.get("api/employee/{emp}/reimbursement", (ctx) -> {
					System.out.println("All Employee Reimbursements endpoint is requested!!");
					ctx.json(reimbursementService.getAllEmpRequests(Integer.parseInt(ctx.pathParam("emp"))));
				});
		// get endpoint to get employee info
		server.get("api/employee/{emp}", (ctx) -> {
			ctx.json(employeeService.viewInfo(Integer.parseInt(ctx.pathParam("emp"))));
		});

		// get endpoint to get employee info
		server.get("api/users/{emp}", (ctx) -> {
			ctx.json(employeeService.viewInfo(Integer.parseInt(ctx.pathParam("emp"))));
		});

		// 500
		// validate User
		server.post("api/users", (ctx) -> {
			UsersPojo returnUsersPojo = usersService.validateUser(ctx.bodyAsClass(UsersPojo.class));
			System.out.println(ctx.json(returnUsersPojo));
			ctx.json(returnUsersPojo);
		});

		//validate User
		server.get("api/users/login/{username}/{password}", (ctx) -> {
			ctx.json(usersService.login(ctx.pathParam("username"), ctx.pathParam("password")));
			System.out.println("LOGIN REACHED");
		});

		// put endpoint to update employee information
		// 500
		server.put("api/employee/{emp}/profile/update", (ctx) -> {
			UsersPojo returnUsersPojo = employeeService.updateInfo(ctx.bodyAsClass(UsersPojo.class));
			ctx.json(returnUsersPojo);
		});

		server.put("api/user/profile/update", (ctx) -> {
			UsersPojo returnUsersPojo = usersService.updateInfo(ctx.bodyAsClass(UsersPojo.class));
			ctx.json(returnUsersPojo);
		});
		// UPDATE EMPLOYEE INFO
		server.put("api/user/{eid}", (ctx) -> {
			 usersService.update(ctx.bodyAsClass(UsersPojo.class));
		});
		

//		server.exception(ApplicationException.class, (ae, ctx) -> {
//			ErrorPojo error = new ErrorPojo();
//			error.setErrorMessage(ae.getMessage());
//			ctx.json(error).status(500);
//		});
	}

}
