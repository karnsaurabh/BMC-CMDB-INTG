<head><link id="orbGrid" type="text/css" href="$!{WEBROOT}/ORB/css/orbGrid.css" rel="stylesheet"></link></head>
<script type="text/javascript" src="$!{WEBROOT}/ORB/RowExpander.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ORB/Ext.ux.Printer.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ext/GridFilters/GridFilters.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ext/GridFilters/menu/RangeMenu.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ext/GridFilters/filter/Filter.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ext/GridFilters/filter/StringFilter.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ext/GridFilters/filter/DateFilter.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ext/GridFilters/filter/ListFilter.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ext/GridFilters/filter/NumericFilter.js"></script>
<script type="text/javascript" src="$!{WEBROOT}/ext/GridFilters/filter/BooleanFilter.js"></script>
<script>
// Global variable to store region names
var regionArray = new Array();
var mrfieldArray =  Array();
var notrequired =new Array(); 
var level2approverflag;
var validdates='Y';
var Object_Created_On;
var Object_Created_By;
var Object_Modified_On;
var Object_Modified_By;
var glob_invokedFromDataBrowser;
var user_chk_avblty;
var edit_flag;
var invokedFromDataBrowser;
var flag = 0;
// Flag that indicates if Level 2 approver is required. Turned off by default.
// For any form where Level2 Approver is required, that form can explicitly
// call F.LEVEL_2_APPROVER.show();
var level2ApproverRequired = 'Y';
//Function to enable the toolbar and the associated buttons
var parvalue='';
var grcReportDiv;
var grcHyperLinkDiv;
var dispToolbar;
function showToolbar()
{
  var editDisabled = false;
  edit_flag = 'Y';
  invokedFromDataBrowser = false;

if (dispToolbar != 'N')
{
   F.activateToolBar();
}

  // If the form is currently under edit, or if the accessCode is 2 (user has does not have the Edit privileges)
  // then dont show the edit Button in the toolbar

  
  if (typeof(F.getFormParameter("edit_flag")) != 'undefined') {
    edit_flag = F.getFormParameter("edit_flag");
    invokedFromDataBrowser = true;
	F.disableAll();
  }
  
 
  //function check added to enable/disable owner organizations field based on whether logged in user is present or not
if (invokedFromDataBrowser  != true ){
  checkUserInOrgs();
}  

if (accessCode != 99) {
  if ( edit_flag != "Y" || accessCode == 2) {
   editDisabled = true;
  }
}

	  
F.log("edit_flag  = " + edit_flag);
F.log("accessCode =  " + accessCode);
F.log("editDisabled = " + editDisabled);
F.log("invokedfromDB = " + invokedFromDataBrowser);

var saveMenu = [];
saveMenu.push({
                iconCls:'msai_toolsavenew',
                xtype:'button',
                id: 'msai_toolsave',
                hidden: editDisabled || (invokedFromDataBrowser),
                tooltip:
                {
                  text: "Saves the content without processing it to the next step",
                  title: "Save Draft",
                  xtype: "quicktip"
                },
                handler: function() { checknsave(); }
              });
saveMenu.push({
                iconCls:'msai_toolsavedraftandclose',
                xtype:'button',
                id: 'msai_toolsavedraftandclose',
                hidden: editDisabled || invokedFromDataBrowser,
                tooltip:
                {
                  text: "Saves the content and closes the form without processing it to the next step",
                  title: "Save Draft &amp; Close",
                  xtype: "quicktip"
                },
                handler: function() { checknsaveclose(); }
              });
	 if (F.DD_OBJECT_TYPE.read() != 'MS_GRC_KPI_KRI_DATA_ENTRY' )
			  {

				var myConfiguration = [
                                {
                                    iconCls: 'msai_tooldefault',
                                    xtype:'button',
                                    id: 'msai_tooldefault',
                                    hidden: editDisabled || (!invokedFromDataBrowser),
                                    tooltip:
                                            {
                                                text: '${editText}',
                                                title: '${editLabel}',
                                                xtype: "quicktip"
                                            },
                                    handler: function() { editForm(); }
                                },
                                {
                                    iconCls:'msai_toolsubmitnew',
                                    xtype:'button',
                                    id: 'msai_toolsubmitnew',
                                    hidden: editDisabled || (invokedFromDataBrowser),
                                    width: 30, 
                                    tooltip:
                                            {
                                                text: '${submitText}',
                                                title: '${submitLabel}',
                                                xtype: "quicktip"
                                            },
                                    handler: function() { checknsubmit(); }
                                },
                                {
                                    iconCls:'msai_toolcancelnew',
                                    xtype:'button',
                                    id: 'msai_toolcancelnew',
                                    hidden: false,
                                    tooltip:
                                            {
                                                text: '${cancelText}',
                                                title: '${cancelLabel}',
                                                xtype: "quicktip"
                                            },
                                    handler: function() { goConfirmCancel(); }
                                }
                            ];
			}
			else
			  {
			  var myConfiguration = [
                                {
                                    iconCls: 'msai_tooldefault',
                                    xtype:'button',
                                    id: 'msai_tooldefault',
                                    hidden: editDisabled || (!invokedFromDataBrowser),
                                    tooltip:
                                            {
                                                text: '${editText}',
                                                title: '${editLabel}',
                                                xtype: "quicktip"
                                            },
                                    handler: function() { editForm(); }
                                },
                                {
                                    iconCls:'msai_toolsubmitnew',
                                    xtype:'button',
                                    id: 'msai_toolsubmitnew',
                                    hidden: editDisabled || (invokedFromDataBrowser),
                                    width: 30, 
                                    tooltip:
                                            {
                                                text: '${submitText}',
                                                title: '${submitLabel}',
                                                xtype: "quicktip"
                                            },
                                    handler: function() { checknsubmit(); }
                                },
                                {
                                    iconCls:'msai_toolreports',
                                    menu : reportsMenu,
                                    tooltip:
                                            {
                                                text: "View/Run the reports that are associated with this form",
                                                title: "View Reports",
                                                xtype: "quicktip"
                                            },
                                    handler: function() {}
                                },
                                {
                                    iconCls:'msai_toolcancelnew',
                                    xtype:'button',
                                    id: 'msai_toolcancel',
                                    hidden: false,
                                    tooltip:
                                            {
                                                text: '${cancelText}',
                                                title: '${cancelLabel}',
                                                xtype: "quicktip"
                                            },
                                    handler: function() { goConfirmCancel(); }
                                }
                            ];
			  }
F.toolBar.setupControls(myConfiguration );

if (dispToolbar != 'N')
{
F.toolBar.show();
addBPMIcon();
}
glob_invokedFromDataBrowser=invokedFromDataBrowser;
}

//Function to call the editable version of the form
function callForm(id, procId)
{
  var paramone = SERVLET_URL + "/Pushinfolet?id=" + id + "&submit_back=no&flag=1";
  //var paramone = SERVLET_URL + "/Pushinfolet?id=" + id + "&";
  if (procId)
  {
    paramone = paramone + '&proc=' + procId;
  }
 // window.parent.location = paramone;
  window.parent.location = paramone+'&bare='+encodeURIComponent(top.window.top.previousPage);
};

function disableMrow(mRow, flag)
{

   mRow.onAddRow = function()
   {
      return false;

   }
   mRow.onDeleteRow = function()
   {
      return false;

   }

   // If the multi - row already has records, then show the first page, otherwise show an empty section
   //msgbox(mRow.getRowCount());
   if (flag == 'SHOW')
   {
      mRow.showFirstPage();
   }
   else
   {
      mRow.makeEmpty();
      mRow.showFirstPage();

   }

   // Disable each of the rows in the multirow
   for(row in mRow.rows())
   {
      mRow.disableRow(row);

   }

   // After each page load, disable the rows in that page, since platform enables it by default
   mRow.afterPageLoad = function(startRow, endRow)
   {
      for (i = startRow; i <= endRow; i ++ )
      {
         mRow.disableRow(i);

      }
   }

}

function enableMrow(mRow, flag)
{

   // Allow the user from adding or deleting rows in the multirow
   mRow.onAddRow = function()
   {
      return true;

   }
   mRow.onDeleteRow = function()
   {
      return true;

   }
   // If there are no rows in the multi - row, show a blank section, otherwise show the first page
   if (flag == 'SHOW')
   {	
      mRow.showFirstPage();		
   }
   else
   {  
      mRow.makeEmpty();
      mRow.showFirstPage();
	  
   }

   // Enable all the rows in the multi - row
   for(row in mRow.rows())
   {	
      mRow.enableRow(row);

   }
}

//to update title
function callUpdateTitle()
{

if (F.OBJECT_ID.read() == 'NONE' && F.OBJECT_NAME.read() == '')
	{

		F.toolBar.updateTitle(F.getTitle() + ': ' + F.OBJECT_NAME.read().substring(0,104)+ ' []' );

	}
else
	{		


			F.log(F.OBJECT_NAME.read().substring(0,104) + ' [' + F.OBJECT_ID.read() + ']');
			F.toolBar.updateTitle(F.getTitle() + ': ' + F.OBJECT_NAME.read().substring(0,104) + ' [' + F.OBJECT_ID.read() + ']');
			

	}
}

//to show / hide parent based on level selected
function showHideParent()
{
   if (F.OBJECT_LEVEL.read() == '1' || F.OBJECT_LEVEL.read() == '')
   {
      F.OBJECT_PARENT.makeNotRequired().hide();
   }
   else
   {
      F.OBJECT_PARENT.makeRequired().show();
   }
}

//to call disableMrow function disable the multi row records
function disableMultiRows()
{
if (regionArray.length != 0)
   {
      for (i = 0; i < regionArray.length; i ++ )
      { 
        if (typeof(mrfieldArray[i]) != "undefined" && mrfieldArray[i].read(1) != '' ) {        
         disableMrow(regionArray[i], 'SHOW');
        } else {
         disableMrow(regionArray[i], 'DONTSHOW');
        }      
      }
   }
}

//to call enableMrow function disable the multi row records
function enableMultiRows()
{
if (regionArray.length != 0)
   {
      for (v = 0; v < regionArray.length; v ++ )
      {
	
	F.log('mrfield array' + mrfieldArray[v]);
		


        if (typeof(mrfieldArray[v])!= "undefined" && mrfieldArray[v].read(1) != '' ) {


	         enableMrow(regionArray[v], 'SHOW');
		} else {
	 F.log('dont show');

         enableMrow(regionArray[v], 'DONTSHOW');
        }
      }
         
   }
}   




// Function to disable all the fields in the form, including multi - row sections (except for the approval section)
function disableCommonFields()
{
   // Disable all single fields
   F.OBJECT_NAME.disable();
   if (F.DESCRIPTION)
   {
   F.DESCRIPTION.disable();
   }
   F.VALID_FROM.disable();
   F.VALID_UNTIL.disable();
   F.OWNER_ORGANIZATIONS.disable();
   F.OWNERS.disable();
   F.RESTRICT_ACCESS_TO.disable();
   F.LEVEL_1_APPROVER.disable();
   disableMultiRows();
}


// Function to enable all the fields in the form, including the multi - row sections
function enableCommonFields()
{
   // Disable all single fields
   F.OBJECT_NAME.enable();
   if (F.DESCRIPTION && F.DD_OBJECT_TYPE.read()!='MS_GRC_QUESTION_PROCEDURE')
   {
   F.DESCRIPTION.enable();
   }
   F.VALID_FROM.enable();
   F.VALID_UNTIL.enable();
   F.OWNER_ORGANIZATIONS.enable();
   F.OWNERS.enable();
   F.RESTRICT_ACCESS_TO.enable();
   F.LEVEL_1_APPROVER.enable();
   enableMultiRows();

}

//Override the showDefault function to show the editable form
//edit_flag value is passed from the browser or the report. If this value is set to "Y", then the form
//is in an editable state.
//Make a call to the callForm to invoke the editable version of the form
//Otherwise, show an alert that the user cannot modify this form at this time

/* Old version commented to implement form level security
F.showDefault = function()
{
  if (F.getFormParameter("edit_flag") == "Y") {
    msgbox(F.getFormParameter("edit_flag") + ' : ' + F.getFormParameter("id") + ' : ' + F.getFormParameter("proc"));
    callForm(F.getFormParameter("id"), F.getFormParameter("proc"));
  } else {
    msgbox("The Object cannot be edited since another user is modifying it at the moment.");
  }
}
*/

function editForm()
{
//starting of alert for MY Profile Report
if (F.getFormParameter("edit_flag") == "N" && F.getFormParameter('spiflg') == '1')
{
  alert("$SPI_Alert06");
}
//end of alert for MY Profile Report

//alert(F.getFormParameter('spiflg'));
//alert(F.getFormParameter('flag'));
//alert(F.getFormParameter('edit_flag'));

  if ((F.getFormParameter("edit_flag") == "Y") || (F.getFormParameter("flag") == "3")){

     if (accessCode == 2)
	{
	F.log("Object cannot be edited due to Security Check Fail.");
	}
	else
	{
	//callForm(F.getFormParameter("id"), F.getFormParameter("proc"));
callForm(F.getFormParameter("id"), F.getFormParameter("new_prid"));

	}
  } else 
{

if (F.getFormParameter('spiflg') != '1') 
{
   alert("$SPI_Alert01");
}




  }
}
	
//function to call for making action comments field to required/optional
function setReqForComments()
{
	if (F.OBJECT_ACTION.read() == 'CNCL' || F.OBJECT_ACTION.read() =='REQ_CLR' )
	{
	 F.ACTION_COMMENTS.makeRequired();
	}
	else
	{
        F.ACTION_COMMENTS.makeNotRequired();

	} 			
}


//below function checks whether level 1 approver field contains any value or not
F.level2Approvercheck = function()
{	
	//**Do not remove F.log line.
	F.log(F.VALID_UNTIL.read());
	if (F.LEVEL_2_APPROVER.read() !="" && F.LEVEL_1_APPROVER.read() =="")
	{
	 alert("$SPI_Alert02");
	  level2approverflag ='N';	 
	  return false;
	}
	else
	{
	level2approverflag ='Y';	
	return true;
	}
}

//Function to populate NONE into primary key columns
F.regionPkeycheck = function()
{


	for (var i = 0; i < regionArray.length; i ++ )
    {

		var cnt = regionArray[i].getRowCount();
		F.log('number of records in '+ regionArray[i]+' = '+cnt);

		for (var j = 1; j <= cnt; j++)
		{

		//F.log('Checking '+ mrpkeyArray[i]+ j + ' record is '+ mrpkeyArray[i].read(j));
//F.log(mrpkeyArray[i].read(j));


			if   (mrpkeyArray[i].read(j) == '') {
				mrpkeyArray[i].write('NONE',j);
			}
		}
	}

}
//custom function to compare dates
function validate_start_and_end_date(check_dt,cre_dt)
   {
    var ret_value = '1';

    var my_chk_date = new Date(check_dt);
    var my_cre_date = new Date(cre_dt);

    var ed_month = my_chk_date.getMonth();
    var ed_date  = my_chk_date.getDate();
    var ed_year  = my_chk_date.getYear();

    var curr_month = my_cre_date.getMonth();
    var curr_date = my_cre_date.getDate();
    var curr_year = my_cre_date.getYear();

    if ( ed_year > curr_year )
    {
        ret_value ='-1';
    }
    else
    {
        if ( ed_year == curr_year )
        {   
            if ( ed_month > curr_month )
            {
                ret_value = '-1';
            }
            else
            {
                if ( ed_month == curr_month)
                {
                    if (   ed_date > curr_date )
                    {
                        ret_value = '-1';
                    }
                }
            }               
        }
    }

    return ret_value;
}

function msgbox(txt,msgType)
{
	//var iconType=Ext.MessageBox.WARNING;
	//if (msgType)
	//{
	//	iconType=msgType;
	//}
	//Ext.Msg.show({title:'Alert',msg:txt,minWidth:200,buttons:Ext.Msg.OK,icon:iconType});
	alert(txt);
	
}

function msgbox1(txt,msgType)
{
	var iconType=Ext.MessageBox.WARNING;
	if (msgType)
	{
		iconType=msgType;
	}
	Ext.Msg.show({title:'Relationship Alert',msg:txt,minWidth:200,buttons:Ext.Msg.OK,icon:iconType});
	
}

function addBPMIcon(){
	if(F.DD_OBJECT_TYPE.read() =="MS_GRC_PROCESS"){
		Ext.Ajax.request({
			url: 'Bpmservlet/ajax/InfoletData',
			method: 'POST',
			params:{
				infoletname:'MS_APPS_BPM'
			},
			success: function(response, options) {
				for(var i=0; i<F.toolBar.configuration.length; i++)
				{
				    if(F.toolBar.configuration[i].id=='msai_toolbpmdesigner')
				    {
					F.toolBar.configuration[i].hidden = false;
					F.toolBar.configuration[i].handler = function() { fnBPMDesigner(response.responseText); }
				    }
				}
				top.setActiveToolbar(F.toolBar.configuration);
			}
		});
	}
}

function fnBPMDesigner(infoletId)
{
   var queryStringObj=Ext.urlDecode(window.location.search.substring(1));
   var allowRedirect=true;
   if (!queryStringObj.edit_flag){
        allowRedirect=false;
      /*Ext.Msg.confirm( 'Confirm','Changes should be saved first to go to BPM page. Do you want to continue?',function(btn, text){
                     if(btn == 'yes'){
                checknsave();
                fnRedirect(infoletId);
                
             }
             else{
                 
                return;
             }
      });*/
      Ext.Msg.show({
           title:'Confirm',
           msg: 'Do you want to save the changes?',
           buttons: Ext.Msg.YESNOCANCEL,
           fn: grcSaveResult,
           icon: Ext.MessageBox.QUESTION
      });
   }
	if(allowRedirect){
        fnRedirect(infoletId);
	}
   		function grcSaveResult(btn) {
        		if(btn=='yes'){
                 	checknsave();
         		fnRedirect(infoletId);
        		}
			else if(btn=='no'){
                	fnRedirect(infoletId);
        		}
			else if(btn=='cancel'){
                	goCancel();
        		}
  		}	
   		function fnRedirect(infoletId){
       		F.getObject('main_container').style.visibility='hidden';
   		var objectId=F.OBJECT_ID.read();
   		var objectName=F.OBJECT_NAME.read();
  		var objectType=F.DD_OBJECT_TYPE.read();
   		var objectInfoletId=F.getInfoletId();
   		var objectLevel=F.OBJECT_LEVEL.read();
   		var objectEditFlag=F.getFormParameter("edit_flag");
  		var objectInstId=F.getFormParameter("instid");
   		var objectProcId=F.getFormParameter("proc");
   		var formmode=(!queryStringObj.edit_flag)?"edit":'view';
  		var objectName=escape(objectName);
   		var objectDrillDown=queryStringObj.OBJECT_DRILLDOWN;
   		var paramone=SERVLET_URL+'/Pushinfolet?flag=1&id='+infoletId+'&OBJECT_ID='+objectId+'&OBJECT_NAME='+objectName+'&OBJECT_TYPE='+objectType+'&OBJECT_ACCESS_CODE='+accessCode+'&OBJECT_FORM_ID='+objectInfoletId+'&OBJECT_FORM_MODE='+formmode+'&OBJECT_LEVEL='+objectLevel+'&OBJECT_EDIT_FLAG='+objectEditFlag+'&OBJECT_INST_ID='+objectInstId+'&OBJECT_PROC_ID='+objectProcId;
                       if(objectDrillDown=='Y')
                             paramone=paramone+"&OBJECT_DRILLDOWN="+objectDrillDown;
                             window.location=paramone+'&bare='+encodeURIComponent(top.window.top.previousPage);
                }
}
function at_submit()
{
//to hide controls on the toolbar after user clicks on submit
	F.toolBar.hideControls();	
}

function afterFormSave()
{
F.toolBar.showControls();
}

function checkUserInOrgs()
{
if (F.CHECK_USER_IN_ORGS)
	{
	F.log('in check_user_in_orgs');
	var values_in_dd;
    values_in_dd= document.getElementById('id'+F.CHECK_USER_IN_ORGS.getSequence()).options.length - 1;
	F.log('values_in_dd ' + values_in_dd );
	if ((F.OBJECT_ID.read() != '') && (F.DD_CURRENT_USER_NAME.read() != 'SYSTEMI'))
		{
		if (values_in_dd >= 1)
			{
			F.OWNER_ORGANIZATIONS.enable();
			}
		else
			{  
			F.OWNER_ORGANIZATIONS.disable();
			}
		}  
	}
}

function approvercheck()
{
if (accessCode == 4) 
	{
	F.disableAll();
	F.OBJECT_ACTION.enable();
	F.ACTION_COMMENTS.enable();
	}
}

function restrictedaccess()
{
if (accessCode == 5) 
	{
	F.OWNER_ORGANIZATIONS.disable();
	}
}

/*function approvercheck(formName)
{
   if ((F.DD_CURRENT_STAGE.read()=='L1_APPROVE'||F.DD_CURRENT_STAGE.read()=='L2_APPROVE')&&(accessCode == 4)&&(F.OBJECT_ACTION.read() =='R'))
   {
      validdates ='Y'
     if(formName =='MS_GRC_REFERENCE')
	   {
	   alert("TEST!!@#");
	   F.REFERENCE_DOCUMENT.makeNotRequired();
	   F.REFERENCE_URL_TYPE.makeNotRequired();
	   F.REFERENCE_URL.makeNotRequired();
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.REFERENCE_TYPE.makeNotRequired();
	   F.REFERENCE_CATEGORY.makeNotRequired();
	   //F.OWNERS.makeNotRequired();
	   }
	  else if(formName =='MS_GRC_OBJECTIVES')
	   {
	  F.OWNER_ORGANIZATIONS.makeNotRequired();
	   }
	  else if (formName =='MS_GRC_AREA_OF_COMPLIANCE')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   MODEL_TYPE
	   ORGANIZATION_NAME
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_FINANCIAL_ACCOUNTS')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   OBJ_CATEGORY
	   OBJ_TYPE
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_FUNCTION')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   RELATIONSHIP
	   OTHER_NAME
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_MODEL_REFERENCE')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   REFERENCE_TYPE
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_ORG_PROFILE')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_PROCESS')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_QUESTION_PROCEDURE')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_REGULATORY_BODY')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_REQUIREMENT')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else if (formName =='MS_GRC_CONTROL')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
	   else (formName =='MS_GRC_RISK')
	   {
	   F.RESTRICT_ACCESS_TO.makeNotRequired();
	   F.OWNER_ORGANIZATIONS.makeNotRequired();
	   F.OWNERS.makeNotRequired();
       }
    }
}
*/
/*function approvercheck(formName)
{
   if ((F.DD_CURRENT_STAGE.read()=='L1_APPROVE'||F.DD_CURRENT_STAGE.read()=='L2_APPROVE')&&(accessCode == 4)&&(F.OBJECT_ACTION.read() =='R'))
   {
      validdates ='Y'
     if(formName =='MS_GRC_REFERENCE')
	   {
      var Makenotrequired =new Array(); 
      approvercheck[0]="Saab";       
      approvercheck[1]="Volvo";
      approvercheck[2]="BMW";*/

function GRC_OnLoad()
{	
	//variable to find emd value if form is opened via link in ORB grid
	parvalue=F.getFormParameter('emd');


	F.log("location.href.indexOf('wrapper=no')"+location.href.indexOf('wrapper=no'));
F.log("edit_flag  = " + edit_flag);
F.log("accessCode =  " + accessCode);
F.log("invokedfromDB = " + glob_invokedFromDataBrowser);

	displaytoolbar();

	//F.OBJECT_NAME.onChange();    

if (parvalue != '3')
   	callUpdateTitle();
 	



	InitiateNewObject();



	status_updation();



	//not calling function if form is opened via link in ORB grid

	if (parvalue  !='3')
{
	showHideComments();
}

	objectCreationInfo();

	objectModificationInfo();


if(F.DD_OBJECT_TYPE.read() != 'MS_SPI_RELATED_DOCUMENTS')
{
	getConfigParams();
}

	//approvercheck();
	restrictedaccess();

	defaultRestriction();

	enableMultiRows();

	if (F.ORB)
	{	
	includeORB();	
	}


}

function status_updation()
{


	F.OBJ_STATUS_TEMP.write('');
	F.OBJ_STATUS_TEMP.write(F.OBJ_STATUS.read());

	if(F.DD_CURRENT_STAGE.read()=='NONE' || F.DD_CURRENT_STAGE.read()=='')
			F.OBJ_STATUS_TEMP.write('NEW');
			
	var cstage=F.DD_CURRENT_STAGE.read();
	var ostatus=F.OBJ_STATUS.read();
        var fparam=F.getFormParameter("edit_flag");
			
       
	//if ((cstage=='CREATE_EDIT') && ((ostatus=='ACT')|| (ostatus=='INACT')) && glob_invokedFromDataBrowser != true)
if ((cstage=='CREATE_EDIT' || cstage =='PUBLISH') && ((ostatus=='ACT')|| (ostatus=='INACT')) && glob_invokedFromDataBrowser == false)

	{
		
		F.OBJ_STATUS_TEMP.write('MOD');
	} 
 
 	F.OBJ_STATUS_TEMP.callInfolet(); 
 	//F.DD_CURRENT_USER_NAME.callInfolet();

}
function GRC_OnSubmit()
{



	var retvalue;	
	//updateRowNum();	
	retvalue = InvokeUserCheck();
	if (retvalue == false)
		return retvalue;
	 //calling  object_Action.onChange to make comments to mandatory when request clarification is selected and form is saved	
	//F.OBJECT_ACTION.onChange();   
setReqForComments();
	F.regionPkeycheck()
	//clarificationcheck();
 	retvalue = F.level2Approvercheck();
 	if (retvalue == false)
		return retvalue;
 	retvalue = datevaliditycheck();

 	return retvalue;
}
//To Find the object's creation date and user (who initiated the Object)

function objectCreationInfo()
{
	var Object_Created_By;
	var date = new Date();
	var d  = date.getDate();
	var day = (d < 10) ? '0' + d : d;
	var m = date.getMonth() + 1;
	var month = (m < 10) ? '0' + m : m;
	var yy = date.getYear();
	var year = (yy < 1000) ? yy + 1900 : yy;

        if(F.OBJ_STATUS_TEMP.read()=='NEW')
	{
 		F.OBJ_CREATED_ON.writeValue(month + "/" + day + "/" + year,month + "/" + day + "/" + year);
    		Object_Created_By=F.DD_CURRENT_USER_NAME.read();
 		F.OBJ_CREATED_BY.writeValue(Object_Created_By,Object_Created_By);
                            
       } 
	else
	return;
}


//To find the object's modification Date and user (who modified the Object)

function objectModificationInfo()
{
	var Object_Modified_By;
	var date = new Date();
	var d  = date.getDate();
	var day = (d < 10) ? '0' + d : d;
	var m = date.getMonth() + 1;
	var month = (m < 10) ? '0' + m : m;
	var yy = date.getYear();
	var year = (yy < 1000) ? yy + 1900 : yy;              	
	if(F.OBJ_STATUS_TEMP.read()=='MOD')
	{
	F.OBJ_MODIFIED_ON.writeValue(month + "/" + day + "/" + year,month + "/" + day + "/" + year);
        Object_Modified_By=F.DD_CURRENT_USER_NAME.read();
        F.OBJ_MODIFIED_BY.writeValue(Object_Modified_By,Object_Modified_By);        
     	}
        	if(F.OBJ_MODIFIED_ON.read()=="" && F.OBJ_MODIFIED_BY.read()=="")
        	{
        	F.OBJ_MODIFIED_ON.hide();
        	F.OBJ_MODIFIED_BY.hide();
        	}
	       	else
	       	return;
  }


function clarificationcheck()
{
if ((F.DD_CURRENT_STAGE.read()=='L1_APPROVE'||F.DD_CURRENT_STAGE.read()=='L2_APPROVE')&&(accessCode == 4)&&(F.OBJECT_ACTION.read() =='R'))
   {
      for (i = 0; i <notrequired.length; i ++ )
      {              	  
         notrequired[i].makeNotRequired();           
      }
   }
}

function getConfigParams()
{

	//F.OWN_APP_CONFIG.onChange();
if(F.OWN_APP_CONFIG_TEMP.read()=='')
			F.OWN_APP_CONFIG_TEMP.write(F.OWN_APP_CONFIG.read());
	if(F.OWN_APP_CONFIG_TEMP.read()=='1')
	{
		F.LEVEL_1_APPROVER.hide();
		F.LEVEL_2_APPROVER.hide();
	}
	else if(F.OWN_APP_CONFIG_TEMP.read()=='2')
	{	
		F.LEVEL_2_APPROVER.hide();
	}

	
	
}


function showHideComments()
{

if (
		/*(F.OBJ_STATUS_TEMP.read() =='NEW') ||
		(F.OBJ_STATUS_TEMP.read() =='ACT')|| 
		(F.OBJ_STATUS_TEMP.read() =='MOD')*/
               
               (F.OBJECT_ID.read() == 'NONE') ||
               (F.OBJECT_ID.read() ==  '')
   )
			{
			var divelem = getReportDiv(F.HDN_CMNT_HIST_RPT_NAME.read());			
			if (divelem != false) divelem.style.display = 'none'; 
			}
}

function InitiateNewObject()
{
    if(F.DD_CURRENT_STAGE.read()==''&& F.OBJECT_ID.read() == '')
         {	
			
            F.OBJECT_ID.write('NONE');
			F.DD_CURRENT_STAGE.write('NONE');
            valueisthere(F.DD_CURRENT_STAGE.getSequence());			
        
         }
//         enableMultiRows();
}		 

function datevaliditycheck()
{
	if ((F.VALID_FROM.read() !='' && F.VALID_UNTIL.read() !='') && (validate_start_and_end_date(F.VALID_FROM.read(),F.VALID_UNTIL.read()) == -1))
	{
		alert("$SPI_Alert03");
		return false;
	}
	else
	{
		return true;
	}

}




function InvokeUserCheck()
{

	if (F.OWNER_ORGANIZATIONS.read() !='' && F.OBJECT_ACTION.read() != '' && F.OBJECT_ACTION != 'CNCL')
	{
		F.OBJECT_ID.callInfolet();
		user_chk_avblty = F.CHECK_USER_AVAIL.read();
		
	}
	if (user_chk_avblty == 1)
		return true;
	else
{
		switch (user_chk_avblty)
		{	
			case 1 : 
				return true;
				break;
			case '-1': 
				alert("$SPI_Alert04");

				return false;
				break;
			case '-2':
				alert("$SPI_Alert05");
				return false;
				break;
			default:	
				return true;

		}
}

}

//Function to set default Restrict Access to as No Restriction for a new form.
function defaultRestriction()
{
	if (F.RESTRICT_ACCESS_TO.read() == '')
	{
		F.RESTRICT_ACCESS_TO.write('N');      

	}
}
function displaytoolbar()
{
   if(location.href.indexOf('wrapper=no') < 1)
   {
      showToolbar();
//      F.OBJECT_NAME.onChange();
   }
   //disable fields if form is opened via link in ORB grid
   if(parvalue == '3')	
		{  		
			F.disableAll();
			disableMultiRows();
            F.OBJECT_ACTION.disable();    		   
       }
}

    //functionality to report link id

    function getReportLinkId() {
        var className = 'msai_attached_report_name';
        var hasClassName = new RegExp("(?:^|\\s)" + className + "(?:$|\\s)");
        var allElements = document.getElementsByTagName("span");
        var results = [];
        var element;
        for (var i = 0;
        (element = allElements[i]) != null; i++) {
            var elementClass = element.className;
            if (elementClass && elementClass.indexOf(className) != -1 && hasClassName.test(elementClass)) {
                results[element.innerHTML] = element.parentNode;
				F.log('*element.innerHTML*' +element.innerHTML);
            }
        }
        return results;
    }
    //end of functionality to report link id
    //Start of functionality to get div id of a linked report

    function getReportDiv(repId) {
        grcReportDiv = grcReportDiv || getReportLinkId();
        for (var i in grcReportDiv) {
            if (repId == i) return grcReportDiv[i];
        }
        return false;
    }

    //end of functionality to get div id of a linked report

	
	//functionality to hyperlink link id

    function getHyperLinkId() {
        var className = 'msai_hyperlink';
        var hasClassName = new RegExp("(?:^|\\s)" + className + "(?:$|\\s)");
		F.log('+hasClassName+' + hasClassName);
        var allElements = document.getElementsByTagName("A");
		F.log('+allElements+' + allElements);
        var results = [];
        var element;
        for (var i = 0;
        (element = allElements[i]) != null; i++) {
            var elementClass = element.className;
            if (elementClass && elementClass.indexOf(className) != -1 && hasClassName.test(elementClass)) {
                results[element.innerHTML] = element.parentNode;
                F.log('+element.innerHTML+' +element.innerHTML);
            }
        }
        return results;
    }
    //end of functionality to report link id
    //Start of functionality to get div id of a linked report

    function getHyperLinkDiv(repId) {
        grcHyperLinkDiv = grcHyperLinkDiv || getHyperLinkId();
		F.log('+grcHyperLinkDiv+' + grcHyperLinkDiv);
        for (var i in grcHyperLinkDiv) {
		F.log('+i+' + i);
		F.log('+repId+' + repId);
            if (repId == i) return grcHyperLinkDiv[i];
        }
        return false;
    }
	

function includeORB()
{
	Ext.onReady(extReady);
	showHideReportLinks();	
	var mrDivId='MSAI_MULTI_DIV_'+F.ORB.getID();
	F.getObject(mrDivId).style.display='none';
	
	if (F.REL_SOURCE_ID.read() == '')
	{
	F.REL_SOURCE_ID.write('NONE');
	F.REL_INST_ID.write('NONE',1);
	F.REL_SOURCE_OBJECT_ID.write('NONE'); //defaulting as if there is any field without any value, field is not appeared in xml
	}
	for (i=1;i<=F.ORB.getRowCount();i++)
	{
			//var OrgEntry = [F.TGT_OBJ_TYPE.read(i),F.TGT_OBJ_NAME.read(i),F.TGT_OBJ_ID.read(i),F.REL_COMMENTS.read(i),F.REL_VALID_FROM.read(i),F.REL_VALID_UNTIL.read(i),F.ROW_NUM.read(i),F.SELF_REL_TYPE.read(i),F.APPLICABLE_TO.read(i),F.ADDITIONAL_DETAILS.read(i)];
			//instead of row num value, write i value. Issue fixed for bug id 49199
			var OrgEntry = [decodeHtmlContent(F.TGT_OBJ_TYPE.read(i)),F.TGT_OBJ_NAME.read(i),F.TGT_OBJ_ID.read(i),F.REL_COMMENTS.read(i),F.REL_VALID_FROM.read(i),F.REL_VALID_UNTIL.read(i),i,F.SELF_REL_TYPE.read(i),F.APPLICABLE_TO.read(i),F.ADDITIONAL_DETAILS.read(i),F.ORB_FORM_URL.read(i)];
			relArr.push(OrgEntry);
			relStore.loadData(relArr);
	}
}

function show_report_risk()
{
  #foreach ($report in $reports)
    #if (${report.name} == 'Add Risk(s)')
       getReport($report.metricId,$report.reportId);
    #end
  #end
}

var addObjId;
function showHideAddObject()
{
//var addObjLink = getReportDiv('Add Object');

	if (F.CONFIGURED_OBJECT_TYPES.read()== '')
	{
		F.getObject(addObjId).style.display="none";
//		if (addObjLink != false) addObjLink.style.display = 'none'; 
	}
	else{
		F.getObject(addObjId).style.display="";
//		if (addObjLink != false) addObjLink.style.display = ''; 
	    }

}




//start of organization,type validation for duplicate row
function ROG_dup_chk()
{
for(i=1;i<=F.ROG.getRowCount();i++) 
{       

               if(!F.ROG.isMarkedForDeletion(i))
               {

                   for(var m1=1;m1<=F.ROG.getRowCount();m1++)
			{

					if(!F.ROG.isMarkedForDeletion(m1))
					{

						if((F.ROG_DUMMY_PK.read(m1) != F.ROG_DUMMY_PK.read(i)) && (m1 != i ) && (F.ROG_RELATION_TYPE.read(m1) == F.ROG_RELATION_TYPE.read(i)) && (F.ROG_ORGANIZATION.read(m1) == F.ROG_ORGANIZATION.read(i)))
						{
							if (F.ROG_DUMMY_PK.read(i)!='')
                           				{                       
                              				alert('The Organization: '+F.ROG_ORGANIZATION.readValue(m1)+'\nType: '+F.ROG_RELATION_TYPE.readValue(m1)+'\nRow: '+F.ROG_DUMMY_PK.readValue(m1)+ '\nhas already been selected.Please select a different organisation or remove duplicate row.');
								return false;
								
						   	} 
						}
					}
			}
		} 
}
}
//end of organization,type validation for duplicate row

var dupMRow2DArr    = new Array();
var dupMRow2DValArr = new Array();
var dupMRowAlertArr = new Array();
var dupregionArr    = new Array();
var dupPKeyArr      = new Array();

function dupMRowChk()
{
	for(REGidx=0;REGidx<dupregionArr.length;REGidx++)
	{
		for(i=1;i<=dupregionArr[REGidx].getRowCount();i++) 
		{       
		   if(!dupregionArr[REGidx].isMarkedForDeletion(i))
		   {
			   for(m1=1;m1<=dupregionArr[REGidx].getRowCount();m1++)
				{
					if(!dupregionArr[REGidx].isMarkedForDeletion(m1))
					{
						if(  (m1 != i )	)
						{
							var eqCnt;
							eqCnt = dupMRow2DArr[REGidx].length;
                                                 var tmpalert ;
						       tmpalert = dupMRowAlertArr[REGidx];

							for(mr2Didx=0;mr2Didx<dupMRow2DArr[REGidx].length;mr2Didx++) 
							{
								if (dupMRow2DArr[REGidx][mr2Didx].read(m1) != dupMRow2DArr[REGidx][mr2Didx].read(i))
								{
									eqCnt = eqCnt - 1;
								}

								if ( (tmpalert.indexOf( dupMRow2DValArr[REGidx][mr2Didx] + '.dispval') >0 ) || (tmpalert.indexOf( dupMRow2DValArr[REGidx][mr2Didx] + '.val') >0 ))
								{
									tmpalert = tmpalert.split(dupMRow2DValArr[REGidx][mr2Didx] + '.dispval').join(dupMRow2DArr[REGidx][mr2Didx].readValue(i));
                                                               tmpalert = tmpalert.split(dupMRow2DValArr[REGidx][mr2Didx] + '.val').join(dupMRow2DArr[REGidx][mr2Didx].read(i));
                                                               tmpalert = tmpalert.split('ROWNUM').join(m1);

								}

							}
							
							if ((eqCnt == dupMRow2DArr[REGidx].length) && eqCnt != 0)
							{   
							     
                                      			alert(tmpalert);
								return false;
							} 
						}
					}
				}
			} 
		}
	}
return true;
}


</script>
