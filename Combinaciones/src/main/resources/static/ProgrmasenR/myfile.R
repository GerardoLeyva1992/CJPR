# myfile.R



#* @get /mul
sumaenr <- function(a, b){
  as.numeric(a) * as.numeric(b)
}

#' @post /summ
addTwo <- function(a, b){
  as.numeric(a) + as.numeric(b)
}
