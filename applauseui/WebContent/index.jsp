<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="scripts/jquery-ui.js" type="text/javascript"></script>
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css"
	media="all" />

<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var table = $("#devices")
								.DataTable(
										{
											"fnInitComplete" : function selecttopRow() {
												$('#devices tbody tr:eq(0)')
														.click();
											},
											"sAjaxSource" : "http://localhost:8080/applauseapi/webapi/device/getall",
											"bProcessing" : true,
											"sAjaxDataProp" : "",
											"sPaginationType" : "full_numbers",
											"bJQueryUI" : true,
											"aoColumns" : [ {
												"mDataProp" : "deviceId",
												"bSearchable" : false,
												"bSortable" : false,
												"bVisible" : true
											}, {
												"mDataProp" : "description"
											}, ]
										});
						$('#devices tbody').on('click', 'tr', function() {
							if ($(this).hasClass('selected')) {
								$(this).removeClass('selected');
							} else {
								table.$('tr.selected').removeClass('selected');
								$(this).addClass('selected');
							}
						});
						/* $('#devices tbody').on( 'click', 'tr', function () {
								$(this).toggleClass('selected');
						} ); */
						$('#devices tbody')
								.on(
										'click',
										'tr',
										function() {
											/* alert(table.cell('.selected', 1)
													.data()); */
											document
													.getElementById('selectedDeviceId').value = table
													.cell('.selected', 0)
													.data();
											document
													.getElementById('selectedDeviceName').value = table
													.cell('.selected', 1)
													.data();

										});

					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var table = $("#country")
								.DataTable(
										{
											"fnInitComplete" : function selecttopRow() {
												$('#country tbody tr:eq(0)')
														.click();
											},
											"sAjaxSource" : "http://localhost:8080/applauseapi/webapi/tester/getallcountry",
											"bProcessing" : true,
											"sAjaxDataProp" : "",
											"sPaginationType" : "full_numbers",
											"bJQueryUI" : true,
											"aoColumns" : [ /* {
																																																																																												"mDataProp" : "testerId",
																																																																																												"bSearchable" : false,
																																																																																												"bSortable" : false,
																																																																																												"bVisible" : false
																																																																																											}, */
											{
												"mDataProp" : "country"
											}, ]
										});
						$('#country tbody').on('click', 'tr', function() {
							if ($(this).hasClass('selected')) {
								$(this).removeClass('selected');
							} else {

								table.$('tr.selected').removeClass('selected');
								$(this).addClass('selected');
							}
						});

						/* $('#country tbody').on('click', 'tr', function() {
							$(this).toggleClass('selected');
						}); */
						$('#country tbody')
								.on(
										'click',
										'tr',
										function() {
											/* alert(table.cell('.selected', 0)
											 .data());  */
											/* document
											.getElementById('selectedCountryId').value = table
											.cell('.selected', 0)
											.data(); */
											document
													.getElementById('selectedCountryName').value = table
													.cell('.selected', 0)
													.data();												
										});

					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var table = $('#selectDevice').DataTable({
							"responsive" : true,
							"bProcessing" : true,
							"bJQueryUI" : true
						});
						var totalDevice = "";
						var rows = $("#selectDevice").dataTable().fnGetNodes();
						for (var i = 0; i < rows.length; i++) {
							var id = ($
									.trim($(rows[i]).find("td:eq(0)").html()) == "") ? 0
									: $
											.trim($(rows[i]).find("td:eq(0)")
													.html());
							var description = ($.trim($(rows[i]).find(
									"td:eq(1)").html()) == "") ? 0 : $.trim($(
									rows[i]).find("td:eq(1)").html());
							totalDevice = totalDevice + id + "-" + description
									+ "\n";
						}
						document.getElementById('totalSelectedDeviceId').value = totalDevice;

						function checkvalue() {
							var id = "";
							var Decription = "";
							sId = $.trim(document
									.getElementById('selectedDeviceId').value);
							//alert(sId);
							if (sId != 'undefined') {
								if (!sId.match(/\S/)) {
									alert('Please select the different device');
								} else {
									if (isExist(sId)) {
										alert('You have entered the device once.')
									} else {

										$('#selectDevice')
												.dataTable()
												.fnAddData(
														[
																$(
																		'#selectedDeviceId')
																		.val(),
																$(
																		'#selectedDeviceName')
																		.val() ])
										var id = ($('#selectedDeviceId').val() == null || $(
												'#selectedDeviceId').val() == "") ? 0
												: $.trim($('#selectedDeviceId')
														.val());
										var description = ($(
												'#selectedDeviceName').val() == null || $(
												'#selectedDeviceName').val() == null) ? 0
												: $.trim($(
														'#selectedDeviceName')
														.val());

										var deviceInfo = $.trim(id) + "-"
												+ $.trim(description) + "\n";

										totalDevice = deviceInfo + totalDevice;
										//alert(totalDevice);
										document
												.getElementById('totalSelectedDeviceId').value = totalDevice;
										/* alert(document
												.getElementById('totalSelectedDeviceId').value);	  */
									}
								}

							} else {
								alert("Select a device from the list");
							}
						}

						function isExist(strd) {
							var testme = false;
							table.column(0).data().each(function(value, index) {
								if ($.trim(strd) == $.trim(value)) {
									testme = true;
								}
							});
							return testme;
						}
						$('#addDevice').click(checkvalue);
						var selectedId = 0;
						var selectedDevice = 0;
						$('#removeDevice')
								.click(
										function() {
											if (selectedId != 0) {
												table.row('.selected').remove()
														.draw(false);
												//alert(selectedId);
												removeSelectedDevice = $
														.trim(selectedId)
														+ $
																.trim(selectedDevice)
														+ "\n";
												//alert(removeSelectedPerson);
												totalDevice = totalDevice
														.replace(
																removeSelectedDevice,
																"");
												//alert(totalPerson);
												selectedId = 0;
												selectedDevice = 0;
												document
														.getElementById('totalSelectedDeviceId').value = totalDevice;
												//alert(totalDevice);
											} else {
												alert("Select a device from the list to remove.");
											}
										});

						$('#selectDevice tbody').on(
								'click',
								'tr',
								function() {
									if ($(this).hasClass('selected')) {
										$(this).removeClass('selected');
									} else {
										table.$('tr.selected').removeClass(
												'selected');
										$(this).addClass('selected');
									}
									selectedId = $.trim(table.cell('.selected',
											0).data())
											+ '-';
									selectedDevice = $.trim(table.cell(
											'.selected', 1).data());
								});
					});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var table = $('#selectCountry').DataTable({
							"responsive" : true,
							"bProcessing" : true,
							"bJQueryUI" : true
						});
						var totalCountry = "";
						var rows = $("#selectCountry").dataTable().fnGetNodes();
						for (var i = 0; i < rows.length; i++) {
							var description = ($.trim($(rows[i]).find(
									"td:eq(1)").html()) == "") ? 0 : $.trim($(
									rows[i]).find("td:eq(1)").html());
							totalCountry = totalCountry + description
							var description = "";
							+"\n";
						}
						document.getElementById('totalSelectedCountryName').value = totalCountry;

						function checkvalue() {
							var Decription = "";
							sName = $
									.trim(document
											.getElementById('selectedCountryName').value);
							//alert(sName);
							if (sName != 'undefined') {
								/* if (!sName.match(/\S/)) {
									alert('Please select the different country');
								} else { */
								if (isExist(sName)) {
									alert('You have entered the country once.')
								} else {

									$('#selectCountry').dataTable()
											.fnAddData(
													[ $('#selectedCountryName')
															.val() ])
									var description = ($('#selectedCountryName')
											.val() == null || $(
											'#selectedCountryName').val() == null) ? 0
											: $.trim($('#selectedCountryName')
													.val());

									var countryInfo = $.trim(description)
											+ "\n";

									totalCountry = countryInfo + totalCountry;
									//alert(totalCountry);
									document
											.getElementById('totalSelectedCountryName').value = totalCountry;

								}
							}

							//}
							else {
								alert("Select a Country from the list");
							}
						}

						function isExist(strd) {
							var testme = false;
							table.column(0).data().each(function(value, index) {
								if ($.trim(strd) == $.trim(value)) {
									testme = true;
								}
							});
							return testme;
						}
						$('#addCountry').click(checkvalue);
						var selectedCountry = 0;
						$('#removeCountry')
								.click(
										function() {
											if (selectedCountry != 0) {
												table.row('.selected').remove()
														.draw(false);
												//alert(selectedId);
												removeSelectedCountry = $
														.trim(selectedCountry)
														+ "\n";
												//alert(removeSelectedPerson);
												totalCountry = totalCountry
														.replace(
																removeSelectedCountry,
																"");
												//alert(totalPerson);											
												selectedCountry = 0;
												document
														.getElementById('totalSelectedCountryName').value = totalCountry;
												//alert(totalCountry);
											} else {
												alert("Select a country from the list to remove.");
											}
										});

						$('#selectCountry tbody').on(
								'click',
								'tr',
								function() {
									if ($(this).hasClass('selected')) {
										$(this).removeClass('selected');
									} else {
										table.$('tr.selected').removeClass(
												'selected');
										$(this).addClass('selected');
									}
									selectedCountry = $.trim(table.cell(
											'.selected', 0).data());
								});
					});
</script>

<script type="text/javascript">
	function toggleDevice() {
		if (document.getElementById("allDevice").checked == true) {
			document.getElementById("addDevice").disabled = true;
			document.getElementById("removeDevice").disabled = true;
			document.getElementById("devices").disabled = true;
			document.getElementById("selectDevice").disabled = true;
		} else {
			document.getElementById("addDevice").disabled = false;
			document.getElementById("removeDevice").disabled = false;
			document.getElementById("devices").disabled = false;
			document.getElementById("selectDevice").disabled = false;
		}
	}

	function toggleCountry() {
		if (document.getElementById("allCountry").checked == true) {
			document.getElementById("addCountry").disabled = true;
			document.getElementById("removeCountry").disabled = true;
			document.getElementById("country").disabled = true;
			document.getElementById("selectCountry").disabled = true;
		} else {
			document.getElementById("addCountry").disabled = false;
			document.getElementById("removeCountry").disabled = false;
			document.getElementById("country").disabled = false;
			document.getElementById("selectCountry").disabled = false;
		}
	}
</script>


</head>
<body>
	<form action="/applauseui/bug/getallbugs" method="post">
		<table
			style="width: 100%; height: 100%; position: absolute; top: 0; bottom: 0; left: 0; right: 0;"
			align="center" cellspacing="0" cellpadding="5">
			<tr align="center">
				<td colspan="3" style="font: bold; color: red;">
					<%
									String errors = (String) request.getAttribute("errors");
									System.out.print(errors);
									if (errors != null)
										out.print(errors);
								%>
				</td>
			</tr>
			<tr align="center">
				<td align="center">
					<table cellspacing="10" align="center" style="border: solid;">
						<tr>
							<td><input type="checkbox" id="allDevice" name="allDevice"
								value="allDevice" onclick="toggleDevice()">All Device</td>
							<td><input type="checkbox" id="allCountry" name="allCountry"
								onclick="toggleCountry()">All Country</td>
						</tr>
					</table>
				</td>
			</tr>



			<tr align="center">

				<td width="85%" style="border-style: none;" align="center">

					<table cellspacing="10" align="center" style="border: solid;">
						<thead>
							<tr>
								<td>
									<table id="devices" class="display nowrap" style="width: 100%">
										<thead>
											<tr align="center">
												<td colspan="2">Device list</td>
											</tr>
											<tr>
												<th>ID</th>
												<th>Description</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</td>
								<td>
									<table id="country" class="display nowrap" style="width: 100%">
										<thead>
											<tr align="center">
												<td colspan="1">Country list</td>
											</tr>
											<tr>
												<!-- <th>ID</th> -->
												<th>Country</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<button id="addDevice" type="button">Add Device</button>
								</td>
								<td>
									<button id="addCountry" type="button">Add Country</button>
								</td>
							</tr>
							<tr>
								<td>
									<table id="selectDevice" class="display nowrap">
										<thead>
											<tr align="center">
												<td colspan="2">Selected Device List</td>
											</tr>

											<tr id="output_newrow">
												<th>Id</th>
												<th>Device</th>
										</thead>
										<tbody>
										</tbody>
									</table>
								</td>
								<td>
									<table id="selectCountry" class="display nowrap">
										<thead>
											<tr align="center">
												<td colspan="2">Selected Country List</td>
											</tr>
											<tr id="output_newrow">
												<!-- <th>Id</th> -->
												<th>Country</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td><button id="removeDevice" type="button">Remove
										Device</button></td>
								<td><button id="removeCountry" type="button">Remove
										Country</button></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									value="Search" align="middle"> <input type="hidden"
									id="selectedDeviceId"> <input type="hidden"
									id="selectedDeviceName" name="SelectedDeviceId"> <input
									type="hidden" id="totalSelectedDeviceId"
									name="totalSelectedDeviceId"> <input type="hidden"
									id="totalSelectedDeviceName" name="totalSelectedDeviceName">
									<input type="hidden" id="selectedCountryId"
									name="selectedCountryId"> <input type="hidden"
									id="selectedCountryName" name="selectedCountryName"> <input
									type="hidden" id="totalSelectedCountryId"
									name="totalSelectedCountryId"> <input type="hidden"
									id="totalSelectedCountryName" name="totalSelectedCountryName">
									<script>
										$(function() {
											$("input[type=submit], button")
													.button();
										});
									</script></td>
							</tr>
							<tr>
								<td colspan="2">
									<table style="width: 100%; height: 100%; border: solid;"
										align="center" cellspacing="0" cellpadding="5">
										<tr style="outline: solid;">
											<th>Tester Id</th>
											<th>Name</th>
											<th>Device</th>
											<th>Total Bug for Deice</th>
										</tr>

										<c:set var="total" value="${0}" />
										<c:set var="testerid" value="${0}" />
										<c:forEach items="${bugCriteriaList}" var="item">
											<tr align="right">
												<td colspan="4"><c:if
														test="${item.testerId!=testerid}">

														<c:if test="${total!=0}">
															Total Bug : <c:out value="${total}" />
														</c:if>

														<c:set var="total" value="0" />
														<c:set var="testerid" value="${item.testerId}" />
													</c:if> <c:if test="${item.testerId==testerid}">
														<c:set var="total"
															value="${total + item.totalBugforDevice}" />
													</c:if></td>
											</tr>



											<tr style="outline: solid;" align="center">
												<td><c:out value="${item.testerId}" /></td>
												<td><c:out value="${item.firstName}" /> <c:out
														value="${item.lastName}" /></td>
												<td><c:out value="${item.description}" /></td>
												<td><c:out value="${item.totalBugforDevice}" /></td>
												<td><c:set var="TesterId" value="${item.testerId}" /></td>
											</tr>
										</c:forEach>
										<tr align="right">
											<td colspan="4">Total Bug: <c:out value="${total}" />
											</td>
										</tr>
									</table>
								</td>
							</tr>
					</table>

					<table>

					</table>
		</table>
	</form>
</body>
</html>