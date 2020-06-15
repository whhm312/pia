
                    <div class="col-md-6">
                        <div class="panel panel-default">
			                <div class="panel-title col-md-12" > 
			                    <h4 class="title col-md-6" style="margin-top:25px">Schedule Date - Writer</h4> 
                                <div class="text-right col-md-6" style="margin-top:15px">
		                           <button type="button" class="btn btn-default m-b-5">Save</button>
		                           <button type="button" class="btn btn-default m-b-5">Delete</button>
                                </div>
                                <br>
                                <br>
	                            	<hr/>
			                </div>
			                
                            <div class="panel-body">
                                <div class="clearfix"></div>
                                <form class="form-horizontal" role="form">
                                
				                <div class="row"> 
				                        <ul class="nav nav-tabs"> 
				                            <li class="active"> 
				                                <a href="#home" data-toggle="tab" aria-expanded="false"> 
				                                    <span class="visible-xs"><i class="fa fa-home"></i></span> 
				                                    <span class="hidden-xs">Schedule</span> 
				                                </a> 
				                            </li> 
				                            <li class=""> 
				                                <a href="#profile" data-toggle="tab" aria-expanded="false"> 
				                                    <span class="visible-xs"><i class="fa fa-user"></i></span> 
				                                    <span class="hidden-xs">Evaluation</span> 
				                                </a> 
				                            </li> 
				                        </ul>
				                        <div class="tab-content">
				                            <div class="tab-pane active" id="home"> 
				                                <%@ include file="schedule.jsp" %>
				                            </div> 
				                            <div class="tab-pane" id="profile"> 
				                                <%@ include file="evaluation.jsp" %>
				                            </div> 
				                        </div> 
				                    </div> 
                                </form>
                            </div>
                        </div>
                    </div>