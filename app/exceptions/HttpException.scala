package exceptions

class HttpException {
  val message: String = ""
}

case class BadRequestException(
  override val message: String = ""
) extends HttpException

case class ConflictException(
  override val message: String = ""
) extends HttpException


case class NotFoundException(
  override val message: String = ""
) extends HttpException

case class InternalServerErrorException(
  override val message: String = ""
) extends HttpException
