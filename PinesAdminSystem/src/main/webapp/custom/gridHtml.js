
var evaluationYesNoDiv = "";
evaluationYesNoDiv += "<div class=\"row\" id=\"newItemDiv\">";
evaluationYesNoDiv += "<div class=\"col-md-12\">";

evaluationYesNoDiv += "<div class=\"panel panel-default\">";
evaluationYesNoDiv += "<div class=\"panel-body\">";
evaluationYesNoDiv += "<div class=\"col-md-12 col-sm-12 text-right\">";
evaluationYesNoDiv += "<button type=\"button\" class=\"btn btn-default\" id=\"addNewLanguageItemButton\">Add Another Language Yes/No Item</button>";
evaluationYesNoDiv += "<button type=\"button\" class=\"btn btn-default\" id=\"newItemsDeleteButton\" style=\"margin-left:5px\">Remove YESNO All Items</button>";
evaluationYesNoDiv += "</div>";

var evaluationYesNoRowDiv = "";
evaluationYesNoRowDiv += "<div class=\"row\" id=\"itemRowDiv\">";
evaluationYesNoRowDiv += "<div class=\"col-md-12 col-sm-12\">";
evaluationYesNoRowDiv += "<table class=\"table table-striped\">";
evaluationYesNoRowDiv += "<thead>";
evaluationYesNoRowDiv += "<tr>";
evaluationYesNoRowDiv += "<th class=\"text-center\" width=\"10%\">Order No</th>";
evaluationYesNoRowDiv += "<th class=\"text-center\" width=\"20%\">Language</th>";
evaluationYesNoRowDiv += "<th class=\"text-center\" width=\"60%\">Item Content</th>";
evaluationYesNoRowDiv += "<th class=\"text-center\" width=\"10%\"><button type=\"button\" class=\"btn btn-default\" id=\"deleteOneItemButton\">Delete</button></th>";
evaluationYesNoRowDiv += "</tr>";
evaluationYesNoRowDiv += "</thead>";
evaluationYesNoRowDiv += "<tbody id=\"newItemTBody\" optionType=\"YESNO\">";
evaluationYesNoRowDiv += "<tr>";
evaluationYesNoRowDiv += "<td>";
evaluationYesNoRowDiv += "<input type=\"number\" class=\"form-control input-sm text-center\" value=\"\" id=\"newOrderNo\" name=\"newOrderNo\" required maxlength=\"4\">";
evaluationYesNoRowDiv += "</td>";
evaluationYesNoRowDiv += "<td>";
evaluationYesNoRowDiv += "<select class=\"form-control input-sm\" id=\"newLanguage\" name=\"newLanguage\" required>";
evaluationYesNoRowDiv += "</select>";
evaluationYesNoRowDiv += "</td>";
evaluationYesNoRowDiv += "<td colspan=\"2\">";
evaluationYesNoRowDiv += "<input type=\"text\" class=\"form-control input-sm\" value=\"\" id=\"newItemContent\" name=\"newItemContent\" required maxlength=\"1000\">";
evaluationYesNoRowDiv += "</td>";
evaluationYesNoRowDiv += "</tr>";
evaluationYesNoRowDiv += "</tbody>";
evaluationYesNoRowDiv += "</table>";
evaluationYesNoRowDiv += "<div class=\"col-lg-12\">";
evaluationYesNoRowDiv += "<div class=\"portlet\">";
evaluationYesNoRowDiv += "<div class=\"portlet-heading bg-primary\">";
evaluationYesNoRowDiv += "<h3 class=\"portlet-title\">Options > YESNO</h3>";
evaluationYesNoRowDiv += "<div class=\"clearfix\"></div>";
evaluationYesNoRowDiv += "</div>";
evaluationYesNoRowDiv += "<div id=\"bg-primary\" class=\"panel-collapse collapse in\">";
evaluationYesNoRowDiv += "<div class=\"portlet-body\">";
evaluationYesNoRowDiv += "<table class=\"table\">";
evaluationYesNoRowDiv += "<tbody id=\"newOptionTBody\">";
evaluationYesNoRowDiv += "<tr>";
evaluationYesNoRowDiv += "<td width=\"15%\" class=\"text-center\">YES</td>";
evaluationYesNoRowDiv += "<td width=\"70%\">";
evaluationYesNoRowDiv += "<input type=\"text\" class=\"form-control input-sm\" value=\"\" id=\"newOptionContent\" name=\"newOptionContent\" required maxlength=\"1000\">";
evaluationYesNoRowDiv += "</td>";
evaluationYesNoRowDiv += "</tr>";
evaluationYesNoRowDiv += "<tr>";
evaluationYesNoRowDiv += "<td class=\"text-center\">NO</td>";
evaluationYesNoRowDiv += "<td>";
evaluationYesNoRowDiv += "<input type=\"text\" class=\"form-control input-sm\" value=\"\" id=\"newOptionContent\" name=\"newOptionContent\" required maxlength=\"1000\">";
evaluationYesNoRowDiv += "</td>";
evaluationYesNoRowDiv += "</tr>";
evaluationYesNoRowDiv += "</tbody>";
evaluationYesNoRowDiv += "</table>";
evaluationYesNoRowDiv += "</div>";
evaluationYesNoRowDiv += "</div>";
evaluationYesNoRowDiv += "</div>";
evaluationYesNoRowDiv += "</div>";
evaluationYesNoRowDiv += "</div>";
evaluationYesNoRowDiv += "</div>";

evaluationYesNoDiv += evaluationYesNoRowDiv;
evaluationYesNoDiv += "</div>";
evaluationYesNoDiv += "</div>";
evaluationYesNoDiv += "</div>";
evaluationYesNoDiv += "</div>";


var evaluationNumberDiv = "";
evaluationNumberDiv += "<div class=\"row\" id=\"newItemDiv\">";
evaluationNumberDiv += "<div class=\"col-md-12\">";
evaluationNumberDiv += "<div class=\"panel panel-default\">";
evaluationNumberDiv += "<div class=\"panel-body\">";
evaluationNumberDiv += "<div class=\"col-md-12 col-sm-12 text-right\">";
evaluationNumberDiv += "<button type=\"button\" class=\"btn btn-default\" id=\"addNewLanguageItemButton\">Add Another Language Number Item</button>";
evaluationNumberDiv += "<button type=\"button\" class=\"btn btn-default\" id=\"newItemsDeleteButton\" style=\"margin-left:5px\">Remove Number All Items</button>";
evaluationNumberDiv += "</div>";


var evaluationNumberRowDiv = "";
evaluationNumberRowDiv += "<div class=\"row\" id=\"itemRowDiv\">";
evaluationNumberRowDiv += "<div class=\"col-md-12 col-sm-12\">";
evaluationNumberRowDiv += "<table class=\"table table-striped\">";
evaluationNumberRowDiv += "<thead>";
evaluationNumberRowDiv += "<tr>";
evaluationNumberRowDiv += "<th class=\"text-center\" width=\"10%\">Order No</th>";
evaluationNumberRowDiv += "<th class=\"text-center\" width=\"20%\">Language</th>";
evaluationNumberRowDiv += "<th class=\"text-center\" width=\"60%\">Item Content</th>";
evaluationNumberRowDiv += "<th class=\"text-center\" width=\"10%\"><button type=\"button\" class=\"btn btn-default\" id=\"deleteOneItemButton\">Delete</button></th>";
evaluationNumberRowDiv += "</tr>";
evaluationNumberRowDiv += "</thead>";
evaluationNumberRowDiv += "<tbody id=\"newItemTBody\" optionType=\"NUMBER\">";
evaluationNumberRowDiv += "<tr>";
evaluationNumberRowDiv += "<td>";
evaluationNumberRowDiv += "<input type=\"number\" class=\"form-control input-sm text-center\" value=\"\" id=\"newOrderNo\" name=\"newOrderNo\" required maxlength=\"4\">";
evaluationNumberRowDiv += "</td>";
evaluationNumberRowDiv += "<td>";
evaluationNumberRowDiv += "<select class=\"form-control input-sm\" id=\"newLanguage\" name=\"newLanguage\" required>";
evaluationNumberRowDiv += "</select>";
evaluationNumberRowDiv += "</td>";
evaluationNumberRowDiv += "<td colspan=\"2\">";
evaluationNumberRowDiv += "<input type=\"text\" class=\"form-control input-sm\" value=\"\" id=\"newItemContent\" name=\"newItemContent\" required maxlength=\"1000\">";
evaluationNumberRowDiv += "</td>";
evaluationNumberRowDiv += "</tr>";
evaluationNumberRowDiv += "</tbody>";
evaluationNumberRowDiv += "</table>";
evaluationNumberRowDiv += "<div class=\"col-lg-12\">";
evaluationNumberRowDiv += "<div class=\"portlet\">";
evaluationNumberRowDiv += "<div class=\"portlet-heading bg-primary\">";
evaluationNumberRowDiv += "<h3 class=\"portlet-title\">Options > NUMBER</h3>";
evaluationNumberRowDiv += "<div class=\"clearfix\"></div>";
evaluationNumberRowDiv += "</div>";
evaluationNumberRowDiv += "<div id=\"bg-primary\" class=\"panel-collapse collapse in\">";
evaluationNumberRowDiv += "<div class=\"portlet-body\">";
evaluationNumberRowDiv += "<table class=\"table\">";
evaluationNumberRowDiv += "<thead>";
evaluationNumberRowDiv += "<tr>";
evaluationNumberRowDiv += "<th class=\"text-center\" width=\"15%\">Option Order No</th>";
evaluationNumberRowDiv += "<th class=\"text-center\" width=\"15%\">Option Number</th>";
evaluationNumberRowDiv += "<th class=\"text-center\">Option Content</th>";
evaluationNumberRowDiv += "<th class=\"text-right\" width=\"10%\">";
evaluationNumberRowDiv += "<button type=\"button\" class=\"btn btn-default\" id=\"newAddOptionButton\">Add Option</button>";
evaluationNumberRowDiv += "</th>";
evaluationNumberRowDiv += "</tr>";
evaluationNumberRowDiv += "</thead>";
evaluationNumberRowDiv += "<tbody id=\"newOptionTBody\">";

var evaluationNumberOptionDiv = "";
evaluationNumberOptionDiv += "<tr>";
evaluationNumberOptionDiv += "<td>";
evaluationNumberOptionDiv += "<input type=\"number\" class=\"form-control input-sm\" value=\"\" id=\"newOptionOrderNo\" name=\"newOptionOrderNo\" required maxlength=\"5\">";
evaluationNumberOptionDiv += "</td>";
evaluationNumberOptionDiv += "<td>";
evaluationNumberOptionDiv += "<input type=\"number\" class=\"form-control input-sm\" value=\"\" id=\"newOptionNumber\" name=\"newOptionNumber\" required maxlength=\"4\">";
evaluationNumberOptionDiv += "</td>";
evaluationNumberOptionDiv += "<td>";
evaluationNumberOptionDiv += "<input type=\"text\" class=\"form-control input-sm\" value=\"\" id=\"newOptionContent\" name=\"newOptionContent\" required maxlength=\"1000\">";
evaluationNumberOptionDiv += "</td>";
evaluationNumberOptionDiv += "<td  class=\"text-center\">";
evaluationNumberOptionDiv += "<button type=\"button\" class=\"btn btn-default\" id=\"newOptionDeleteButton\">Delete</button>";
evaluationNumberOptionDiv += "</td>";
evaluationNumberOptionDiv += "</tr>";

evaluationNumberRowDiv += evaluationNumberOptionDiv;
evaluationNumberRowDiv += "</tbody>";
evaluationNumberRowDiv += "</table>";
evaluationNumberRowDiv += "</div>";
evaluationNumberRowDiv += "</div>";
evaluationNumberRowDiv += "</div>";
evaluationNumberRowDiv += "</div>";
evaluationNumberRowDiv += "</div>";
evaluationNumberRowDiv += "</div>";

evaluationNumberDiv += evaluationNumberRowDiv;
evaluationNumberDiv += "</div>";
evaluationNumberDiv += "</div>";
evaluationNumberDiv += "</div>";
evaluationNumberDiv += "</div>";


var evaluationOpinionDiv = "";
evaluationOpinionDiv += "<div class=\"row\" id=\"newItemDiv\">";
evaluationOpinionDiv += "<div class=\"col-md-12\">";
evaluationOpinionDiv += "<div class=\"panel panel-default\">";
evaluationOpinionDiv += "<div class=\"panel-body\">";
evaluationOpinionDiv += "<div class=\"col-md-12 col-sm-12 text-right\">";
evaluationOpinionDiv += "<button type=\"button\" class=\"btn btn-default\" id=\"addNewLanguageItemButton\">Add Another Language Opinion Item</button>";
evaluationOpinionDiv += "<button type=\"button\" class=\"btn btn-default\" id=\"newItemsDeleteButton\" style=\"margin-left:5px\">Remove Opinion All Items</button>";
evaluationOpinionDiv += "</div>";

var evaluationOpinionRowDiv = ""
evaluationOpinionRowDiv += "<div class=\"row\" id=\"itemRowDiv\">";
evaluationOpinionRowDiv += "<div class=\"col-md-12 col-sm-12\">";
evaluationOpinionRowDiv += "<table class=\"table table-striped\">";
evaluationOpinionRowDiv += "<thead>";
evaluationOpinionRowDiv += "<tr>";
evaluationOpinionRowDiv += "<th class=\"text-center\" width=\"10%\">Order No</th>";
evaluationOpinionRowDiv += "<th class=\"text-center\" width=\"20%\">Language</th>";
evaluationOpinionRowDiv += "<th class=\"text-center\" width=\"60%\">Item Content</th>";
evaluationOpinionRowDiv += "<th class=\"text-center\" width=\"10%\"><button type=\"button\" class=\"btn btn-default\" id=\"deleteOneItemButton\">Delete</button></th>";
evaluationOpinionRowDiv += "</tr>";
evaluationOpinionRowDiv += "</thead>";
evaluationOpinionRowDiv += "<tbody id=\"newItemTBody\" optionType=\"OPINION\">";
evaluationOpinionRowDiv += "<tr>";
evaluationOpinionRowDiv += "<td>";
evaluationOpinionRowDiv += "<input type=\"number\" class=\"form-control input-sm text-center\" value=\"\" id=\"newOrderNo\" name=\"newOrderNo\" required maxlength=\"4\">";
evaluationOpinionRowDiv += "</td>";
evaluationOpinionRowDiv += "<td>";
evaluationOpinionRowDiv += "<select class=\"form-control input-sm\" id=\"newLanguage\" name=\"newLanguage\" required>";
evaluationOpinionRowDiv += "</select>";
evaluationOpinionRowDiv += "</td>";
evaluationOpinionRowDiv += "<td colspan=\"2\">";
evaluationOpinionRowDiv += "<input type=\"text\" class=\"form-control input-sm\" value=\"\" id=\"newItemContent\" name=\"newItemContent\" required maxlength=\"1000\">";
evaluationOpinionRowDiv += "</td>";
evaluationOpinionRowDiv += "</tr>";
evaluationOpinionRowDiv += "</tbody>";
evaluationOpinionRowDiv += "</table>";
evaluationOpinionRowDiv += "<div class=\"col-lg-12\">";
evaluationOpinionRowDiv += "<div class=\"portlet\">";
evaluationOpinionRowDiv += "<div class=\"portlet-heading bg-primary\">";
evaluationOpinionRowDiv += "<h3 class=\"portlet-title\">Options > OPINION</h3>";
evaluationOpinionRowDiv += "<div class=\"clearfix\"></div>";
evaluationOpinionRowDiv += "</div>";
evaluationOpinionRowDiv += "</div>";
evaluationOpinionRowDiv += "</div>";
evaluationOpinionRowDiv += "</div>";
evaluationOpinionRowDiv += "</div>";

evaluationOpinionDiv += evaluationOpinionRowDiv;
evaluationOpinionDiv += "</div>";
evaluationOpinionDiv += "</div>";
evaluationOpinionDiv += "</div>";
evaluationOpinionDiv += "</div>";


function getOpinionItem(evaluationGroupSeq, evaluationSeq, evaluationItemSeq, orderNo, language, itemContent) {

	var html = "";
	html += "<div class=\"row\" id=\"newItemDiv\">";
	html += "<div class=\"col-md-12\">";
	html += "<div class=\"panel panel-default\">";
	html += "<div class=\"panel-body\">";
	html += "<div class=\"col-md-12 col-sm-12 text-right\">";
	html += "<button type=\"button\" class=\"btn btn-default\" id=\"addNewLanguageItemButton\" evaluationSeq=\"" + evaluationSeq + "\" evaluationGroupSeq=\"" + evaluationGroupSeq + "\" evaluationItemSeq=\"" + evaluationItemSeq + "\" optionType=\"OPINION\">Add Another Language Item</button>";
	html += "</div>";
	
	html += getOpinionDiffLangItem(evaluationGroupSeq, evaluationItemSeq, orderNo, language, itemContent);

	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	
	return html;
}

function getOpinionDiffLangItem(evaluationGroupSeq, evaluationItemSeq, orderNo, language, itemContent) {
	
	var html = "";
	html += "<div class=\"row\" id=\"itemRowDiv\">";
	html += "<div class=\"col-md-12 col-sm-12\">";
	html += "<table class=\"table table-striped\">";
	html += "<thead>";
	html += "<tr>";
	html += "<th class=\"text-center\" width=\"10%\">Order No</th>";
	html += "<th class=\"text-center\" width=\"20%\">Language</th>";
	html += "<th class=\"text-center\" width=\"60%\">Item Content</th>";
	html += "<th class=\"text-center\" width=\"10%\"><button type=\"button\" class=\"btn btn-default\" id=\"deleteEvaludationItem\" evaluationItemSeq=\"" + evaluationItemSeq + "\">Delete</button></th>";
	html += "</tr>";
	html += "</thead>";
	html += "<tbody id=\"newItemTBody\" optionType=\"OPINION\">";
	html += "<tr>";
	html += "<td class=\"text-center\">";
	html += orderNo;
	html += "</td>";
	html += "<td class=\"text-center\">";
	html += language;
	html += "</select>";
	html += "</td>";
	html += "<td colspan=\"2\">";
	html += itemContent;
	html += "</td>";
	html += "</tr>";
	html += "</tbody>";
	html += "</table>";
	html += "<div class=\"col-lg-12\">";
	html += "<div class=\"portlet\">";
	html += "<div class=\"portlet-heading bg-primary\">";
	html += "<h3 class=\"portlet-title\">Options > OPINION</h3>";
	html += "<div class=\"clearfix\"></div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	return html;
}


function getNumberItem(evaluationGroupSeq, evaluationSeq, evaluationItemSeq, orderNo, language, itemContent, options) {

	var html = "";
	html += "<div class=\"row\" id=\"newItemDiv\">";
	html += "<div class=\"col-md-12\">";
	html += "<div class=\"panel panel-default\">";
	html += "<div class=\"panel-body\">";
	html += "<div class=\"col-md-12 col-sm-12 text-right\">";
	html += "<button type=\"button\" class=\"btn btn-default\" id=\"addNewLanguageItemButton\" evaluationSeq=\"" + evaluationSeq + "\" evaluationGroupSeq=\"" + evaluationGroupSeq + "\" evaluationItemSeq=\"" + evaluationItemSeq + "\" optionType=\"NUMBER\">Add Another Language Item</button>";
	html += "</div>";

	html += getNumberDiffLangItem(evaluationGroupSeq, evaluationItemSeq, orderNo, language, itemContent, options);

	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	
	return html;
}

function getNumberDiffLangItem(evaluationGroupSeq, evaluationItemSeq, orderNo, language, itemContent, options) {
	
	var html = "";
	html += "<div class=\"row\" id=\"itemRowDiv\" evaluationItemSeq=\"" + evaluationItemSeq + "\">";
	html += "<div class=\"col-md-12 col-sm-12\">";
	html += "<table class=\"table table-striped\">";
	html += "<thead>";
	html += "<tr>";
	html += "<th class=\"text-center\" width=\"10%\">Order No</th>";
	html += "<th class=\"text-center\" width=\"20%\">Language</th>";
	html += "<th class=\"text-center\" width=\"60%\">Item Content</th>";
	html += "<th class=\"text-center\" width=\"10%\"><button type=\"button\" class=\"btn btn-default\" id=\"deleteEvaludationItem\" evaluationItemSeq=\"" + evaluationItemSeq + "\">Delete</button></th>";
	html += "</tr>";
	html += "</thead>";
	html += "<tbody id=\"newItemTBody\" optionType=\"NUMBER\">";
	html += "<tr>";
	html += "<td class=\"text-center\">";
	html += orderNo;
	html += "</td>";
	html += "<td class=\"text-center\">";
	html += language;
	html += "</select>";
	html += "</td>";
	html += "<td colspan=\"2\">";
	html += itemContent;
	html += "</td>";
	html += "</tr>";
	html += "</tbody>";
	html += "</table>";
	html += "<div class=\"col-lg-12\">";
	html += "<div class=\"portlet\">";
	html += "<div class=\"portlet-heading bg-primary\">";
	html += "<h3 class=\"portlet-title\">Options > NUMBER</h3>";
	html += "<div class=\"clearfix\"></div>";
	html += "</div>";
	html += "<div id=\"bg-primary\" class=\"panel-collapse collapse in\">";
	html += "<div class=\"portlet-body\">";
	html += "<table class=\"table\">";
	html += "<thead>";
	html += "<tr>";
	html += "<th class=\"text-center\" width=\"15%\">Option Order No</th>";
	html += "<th class=\"text-center\" width=\"15%\">Option Number</th>";
	html += "<th class=\"text-center\">Option Content</th>";
	html += "<th class=\"text-right\" width=\"10%\">";
	html += "<button type=\"button\" class=\"btn btn-default\" id=\"newAddOptionButton\" evaluationItemSeq=\"" + evaluationItemSeq + "\">Add Option</button>";
	html += "</th>";
	html += "</tr>";
	html += "</thead>";
	html += "<tbody id=\"newOptionTBody\">";
	
	var optionHtml = "";
	$.each(options, function(idx, val) {
		optionHtml = "";
		optionHtml += "<tr>";
		optionHtml += "<td class=\"text-center\">";
		optionHtml += val.orderNo;
		optionHtml += "</td>";
		optionHtml += "<td class=\"text-center\">";
		optionHtml += val.optionNo;
		optionHtml += "</td>";
		optionHtml += "<td>";
		optionHtml += val.optionContent;
		optionHtml += "</td>";
		optionHtml += "<td  class=\"text-center\">";
		optionHtml += "<button type=\"button\" class=\"btn btn-default\" id=\"deleteOption\" optionSeq=\"" + val.optionSeq + "\" evaluationItemSeq=\"" + evaluationItemSeq + "\">Delete</button>";
		optionHtml += "</td>";
		optionHtml += "</tr>";
		html += optionHtml;
	});
	
	html += "</tbody>";
	html += "</table>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	return html;
}

function addNumberItem(evaluationItemSeq) {
	var html = "";
	html += "<tr>";
	html += "<td class=\"text-center\">";
	html += "<input type=\"number\" class=\"form-control input-sm text-center\" value=\"\" id=\"newOrderNo\" name=\"newOrderNo\" required maxlength=\"4\">";
	html += "</td>";
	html += "<td class=\"text-center\">";
	html += "<select class=\"form-control input-sm\" id=\"newLanguage\" name=\"newLanguage\" required>";
	html += "</td>";
	html += "<td>";
	html += "<input type=\"text\" class=\"form-control input-sm\" value=\"\" id=\"newItemContent\" name=\"newItemContent\" required maxlength=\"1000\">";
	html += "</td>";
	html += "<td  class=\"text-center\">";
	html += "<button type=\"button\" class=\"btn btn-default\" id=\"deleteOption\" optionSeq=\"0\" evaluationItemSeq=\"" + evaluationItemSeq + "\">Delete</button>";
	html += "</td>";
	html += "</tr>";
	return html;
}


function getYesNoItem(evaluationGroupSeq, evaluationSeq, evaluationItemSeq, orderNo, language, itemContent, yesSeq, yes, noSeq, no) {

	var html = "";
	html += "<div class=\"row\" id=\"newItemDiv\">";
	html += "<div class=\"col-md-12\">";

	html += "<div class=\"panel panel-default\">";
	html += "<div class=\"panel-body\">";
	html += "<div class=\"col-md-12 col-sm-12 text-right\">";
	html += "<button type=\"button\" class=\"btn btn-default\" id=\"addNewLanguageItemButton\" evaluationSeq=\"" + evaluationSeq + "\" evaluationGroupSeq=\"" + evaluationGroupSeq + "\" evaluationItemSeq=\"" + evaluationItemSeq + "\" optionType=\"YESNO\">Add Another Language Item</button>";
	html += "</div>";

	html += getYesNoDiffLangItem(evaluationGroupSeq, evaluationItemSeq, orderNo, language, itemContent, yesSeq, yes, noSeq, no);

	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";	
	return html;
}

function getYesNoDiffLangItem(evaluationGroupSeq, evaluationItemSeq, orderNo, language, itemContent, yesSeq, yes, noSeq, no) {
	
	var html = "";
	html += "<div class=\"row\" id=\"itemRowDiv\">";
	html += "<div class=\"col-md-12 col-sm-12\">";
	html += "<table class=\"table table-striped\">";
	html += "<thead>";
	html += "<tr>";
	html += "<th class=\"text-center\" width=\"10%\">Order No</th>";
	html += "<th class=\"text-center\" width=\"20%\">Language</th>";
	html += "<th class=\"text-center\" width=\"60%\">Item Content</th>";
	html += "<th class=\"text-center\" width=\"10%\"><button type=\"button\" class=\"btn btn-default\" id=\"deleteEvaludationItem\" evaluationItemSeq=\"" + evaluationItemSeq + "\">Delete</button></th>";
	html += "</tr>";
	html += "</thead>";
	html += "<tbody id=\"newItemTBody\" optionType=\"YESNO\">";
	html += "<tr>";
	html += "<td class=\"text-center\">";
	html += orderNo;
	html += "</td>";
	html += "<td class=\"text-center\">";
	html += language;
	html += "</select>";
	html += "</td>";
	html += "<td colspan=\"2\">";
	html += itemContent;
	html += "</td>";
	html += "</tr>";
	html += "</tbody>";
	html += "</table>";
	html += "<div class=\"col-lg-12\">";
	html += "<div class=\"portlet\">";
	html += "<div class=\"portlet-heading bg-primary\">";
	html += "<h3 class=\"portlet-title\">Options > YESNO</h3>";
	html += "<div class=\"clearfix\"></div>";
	html += "</div>";
	html += "<div id=\"bg-primary\" class=\"panel-collapse collapse in\">";
	html += "<div class=\"portlet-body\">";
	html += "<table class=\"table\">";
	html += "<tbody id=\"newOptionTBody\">";
	
	html += "<tr>";
	html += "<td width=\"15%\" class=\"text-center\">YES</td>";
	html += "<td width=\"70%\">";
	html += yes;
	html += "<input type=\"hidden\" optionSeq=\"" + yesSeq + "\">";
	html += "</td>";
	html += "</tr>";
	html += "<tr>";
	html += "<td class=\"text-center\">NO</td>";
	html += "<td>";
	html += no;
	html += "<input type=\"hidden\" optionSeq=\"" + noSeq + "\">";
	html += "</td>";
	html += "</tr>";
	
	
	html += "</tbody>";
	html += "</table>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	html += "</div>";
	return html;
}